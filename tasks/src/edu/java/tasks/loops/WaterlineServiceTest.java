package edu.java.tasks.loops;

import edu.java.tasks.util.TestResults;

import static edu.java.tasks.util.Helper.printTestResults;

public class WaterlineServiceTest {
    private final String testName = getClass().getSimpleName();

    private static int testsPassed = 0;
    private static int testsFailed = 0;

    public static void main() {
        printTestResults(new WaterlineServiceTest().run());
    }

    public TestResults run() {
        WaterlineService service = new WaterlineService();

        System.out.printf("\n=== Test Starting %s ===\n\n", testName);
        System.out.println("=== Testing calcUnderWaterCount ===");
        testUnderWaterEmptyArray(service);
        testUnderWaterAllAboveWaterline(service);
        testUnderWaterAllBelowWaterline(service);
        testUnderWaterMixedValues(service);
        testUnderWaterExactWaterline(service); // Strictly below check
        testUnderWaterZeroWaterline(service);
        testUnderWaterNegativeTerrain(service);
        testUnderWaterNegativeWaterline(service);
        testUnderWaterLargeArray(service);

        System.out.println("\n=== Testing calcWaterVolume ===");
        testWaterVolumeEmptyArray(service);
        testWaterVolumeNoWater(service);
        testWaterVolumeSimpleValley(service);
        testWaterVolumeDeepValley(service);
        testWaterVolumeExactWaterline(service); // Volume should be 0
        testWaterVolumeZeroWaterline(service);
        testWaterVolumeNegativeTerrain(service);
        testWaterVolumeLargeValues(service);
        testWaterVolumeComplexTerrain(service);
        testWaterVolumeSingleBlockDeep(service);
        testComplexTerrain(service);

        return new TestResults(testsPassed, testsFailed, testName);
    }

    // ==================== calcUnderWaterCount Tests ====================

    private void testUnderWaterEmptyArray(WaterlineService service) {
        String testName = "Empty terrain array";
        try {
            int result = service.calcUnderWaterCount(new int[]{}, 5);
            assertEqual(result, 0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testUnderWaterAllAboveWaterline(WaterlineService service) {
        String testName = "All blocks above waterline";
        try {
            // Terrain: [10, 11, 12], Waterline: 5
            int result = service.calcUnderWaterCount(new int[]{10, 11, 12}, 5);
            assertEqual(result, 0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testUnderWaterAllBelowWaterline(WaterlineService service) {
        String testName = "All blocks below waterline";
        try {
            // Terrain: [1, 2, 3], Waterline: 5
            int result = service.calcUnderWaterCount(new int[]{1, 2, 3}, 5);
            assertEqual(result, 3, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testUnderWaterMixedValues(WaterlineService service) {
        String testName = "Mixed heights (some above, some below)";
        try {
            // Terrain: [0, 0, 1, 0, 1, 1, 1, 2, 2, 2, 1, 0, 0], Waterline: 1
            // Below 1: 0, 0, 0, 0, 0, 0 -> 6 blocks
            int[] terrain = {0, 0, 1, 0, 1, 1, 1, 2, 2, 2, 1, 0, 0};
            int result = service.calcUnderWaterCount(terrain, 1);
            assertEqual(result, 5, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testUnderWaterExactWaterline(WaterlineService service) {
        String testName = "Blocks exactly at waterline (should NOT count)";
        try {
            // Terrain: [5, 5, 5], Waterline: 5
            // Strictly below means 5 is NOT counted
            int result = service.calcUnderWaterCount(new int[]{5, 5, 5}, 5);
            assertEqual(result, 0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testUnderWaterZeroWaterline(WaterlineService service) {
        String testName = "Zero waterline (only negatives count)";
        try {
            // Terrain: [-1, 0, 1], Waterline: 0
            // Only -1 is strictly below 0
            int result = service.calcUnderWaterCount(new int[]{-1, 0, 1}, 0);
            assertEqual(result, 1, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testUnderWaterNegativeTerrain(WaterlineService service) {
        String testName = "Negative terrain heights";
        try {
            // Terrain: [-5, -2, 0, 3], Waterline: -1
            // Below -1: -5, -2 -> 2 blocks
            int result = service.calcUnderWaterCount(new int[]{-5, -2, 0, 3}, -1);
            assertEqual(result, 2, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testUnderWaterNegativeWaterline(WaterlineService service) {
        String testName = "Negative waterline with positive terrain";
        try {
            // Terrain: [1, 2, 3], Waterline: -5
            // None are below -5
            int result = service.calcUnderWaterCount(new int[]{1, 2, 3}, -5);
            assertEqual(result, 0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testUnderWaterLargeArray(WaterlineService service) {
        String testName = "Large array with alternating pattern";
        try {
            int[] terrain = new int[100];
            for (int i = 0; i < 100; i++) {
                terrain[i] = (i % 2 == 0) ? 10 : 5;
            }
            // Waterline 8: All '5's are below. There are 50 of them.
            int result = service.calcUnderWaterCount(terrain, 8);
            assertEqual(result, 50, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    // ==================== calcWaterVolume Tests ====================

    private void testWaterVolumeEmptyArray(WaterlineService service) {
        String testName = "Empty terrain volume";
        try {
            int result = service.calcWaterVolume(new int[]{}, 10);
            assertEqual(result, 0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testWaterVolumeNoWater(WaterlineService service) {
        String testName = "No water (all above waterline)";
        try {
            int result = service.calcWaterVolume(new int[]{10, 20, 30}, 5);
            assertEqual(result, 0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testWaterVolumeSimpleValley(WaterlineService service) {
        String testName = "Simple valley (depth 1)";
        try {
            // Terrain: [0, 0, 0], Waterline: 1
            // Each block has depth 1. Total volume = 1+1+1 = 3
            int result = service.calcWaterVolume(new int[]{0, 0, 0}, 1);
            assertEqual(result, 3, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testWaterVolumeDeepValley(WaterlineService service) {
        String testName = "Deep valley (varying depths)";
        try {
            // Terrain: [10, 5, 2], Waterline: 15
            // Block 1: 15 - 10 = 5
            // Block 2: 15 - 5 = 10
            // Block 3: 15 - 2 = 13
            // Total: 5 + 10 + 13 = 28
            int result = service.calcWaterVolume(new int[]{10, 5, 2}, 15);
            assertEqual(result, 28, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testWaterVolumeExactWaterline(WaterlineService service) {
        String testName = "Blocks exactly at waterline (volume 0)";
        try {
            // Terrain: [5, 5, 5], Waterline: 5
            // Depth is 0 for all
            int result = service.calcWaterVolume(new int[]{5, 5, 5}, 5);
            assertEqual(result, 0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testWaterVolumeZeroWaterline(WaterlineService service) {
        String testName = "Zero waterline with negative terrain";
        try {
            // Terrain: [-2, -1, 0, 1], Waterline: 0
            // Block 1: 0 - (-2) = 2
            // Block 2: 0 - (-1) = 1
            // Block 3: 0 - 0 = 0
            // Total: 3
            int result = service.calcWaterVolume(new int[]{-2, -1, 0, 1}, 0);
            assertEqual(result, 3, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testWaterVolumeNegativeTerrain(WaterlineService service) {
        String testName = "Negative terrain with positive waterline";
        try {
            // Terrain: [-5, -2], Waterline: 2
            // Block 1: 2 - (-5) = 7
            // Block 2: 2 - (-2) = 4
            // Total: 11
            int result = service.calcWaterVolume(new int[]{-5, -2}, 2);
            assertEqual(result, 11, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testWaterVolumeLargeValues(WaterlineService service) {
        String testName = "Large height difference";
        try {
            // Terrain: [0], Waterline: 1000
            // Depth: 1000
            int result = service.calcWaterVolume(new int[]{0}, 1000);
            assertEqual(result, 1000, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testWaterVolumeComplexTerrain(WaterlineService service) {
        String testName = "Complex terrain (mixed highs and lows)";
        try {
            // Terrain: [0, 0, 1, 0, 1, 1, 1, 2, 2, 2, 1, 0, 0], Waterline: 1
            // Depths:
            // 0 -> 1-0=1
            // 0 -> 1
            // 1 -> 0 (not below)
            // 0 -> 1
            // 1 -> 0
            // 1 -> 0
            // 1 -> 0
            // 2 -> 0
            // ... rest are >= 1
            // Total volume: 1 + 1 + 1 = 3
            int[] terrain = {0, 0, 1, 0, 1, 1, 1, 2, 2, 2, 1, 0, 0};
            int result = service.calcWaterVolume(terrain, 1);
            assertEqual(result, 5, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testWaterVolumeSingleBlockDeep(WaterlineService service) {
        String testName = "Single deep block";
        try {
            // Terrain: [-100], Waterline: 50
            // Depth: 50 - (-100) = 150
            int result = service.calcWaterVolume(new int[]{-100}, 50);
            assertEqual(result, 150, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testComplexTerrain(WaterlineService service) {
        String testName = "Complex terrain";
        try {
            int result = service.calcWaterVolume(new int[]{1, -5, 17, 22, 18, -10, -100, -99, 16, 17, 2, 0, 1}, -3);
            assertEqual(result, 202, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    // ==================== Helper Methods ====================
    private void assertEqual(int actual, int expected, String testName) {
        if (actual != expected) {
            throw new RuntimeException(
                    String.format("%s FAILED: Expected %d, got %d", testName, expected, actual)
            );
        }
    }

    private void pass(String testName) {
        testsPassed++;
        System.out.println("✓ PASS: " + testName);
    }

    private void fail(String testName, String errorMessage) {
        testsFailed++;
        System.out.println("✗ FAIL: " + testName + " - " + errorMessage);
    }
}