package edu.java.tasks.conditions;

import edu.java.tasks.util.TestResults;

import static edu.java.tasks.util.Helper.printTestResults;
public class TimeServiceTest {
    private final String testName = this.getClass().getSimpleName();

    private int testsPassed = 0;
    private int testsFailed = 0;

    public static void main(String[] args) {
        printTestResults(new TimeServiceTest().run());
    }

    public TestResults run() {
        TimeService service = new TimeService();

        System.out.printf("\n=== Test Starting %s ===\n\n", testName);
        System.out.println("=== Testing isInRange (Basic Scenarios) ===");
        testInsideRange(service);
        testExactlyAtStart(service);
        testExactlyAtEnd(service);
        testJustBeforeEnd(service);
        testJustAfterEnd(service);
        testJustBeforeStart(service);

        System.out.println("\n=== Testing isInRange (Edge Cases & Boundaries) ===");
        testStartEqualsEnd(service); // Empty range, always false
        testStartGreaterThanEnd(service); // Invalid range, usually false
        testSinglePointRange(service); // start == end - 1

        System.out.println("\n=== Testing isInRange (Negative & Zero Values) ===");
        testNegativeTimestamps(service);
        testZeroTimestamps(service);
        testCrossingZero(service);

        System.out.println("\n=== Testing isInRange (Integer Limits) ===");
        testMaxIntValues(service);
        testMinIntValues(service);
        testNearOverflow(service);

        return new TestResults(testsPassed, testsFailed, testName);
    }

    // ==================== Basic Scenarios ====================
    private void testInsideRange(TimeService service) {
        String testName = "Value strictly inside range";
        try {
            // Range [100, 200), Value 150
            boolean result = service.isInRange(150, 100, 200);
            assertTrue(result, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testExactlyAtStart(TimeService service) {
        String testName = "Value exactly at start (inclusive)";
        try {
            // Range [100, 200), Value 100
            boolean result = service.isInRange(100, 100, 200);
            assertTrue(result, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testExactlyAtEnd(TimeService service) {
        String testName = "Value exactly at end (exclusive)";
        try {
            // Range [100, 200), Value 200
            boolean result = service.isInRange(200, 100, 200);
            assertFalse(result, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testJustBeforeEnd(TimeService service) {
        String testName = "Value just before end";
        try {
            // Range [100, 200), Value 199
            boolean result = service.isInRange(199, 100, 200);
            assertTrue(result, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testJustAfterEnd(TimeService service) {
        String testName = "Value just after end";
        try {
            // Range [100, 200), Value 201
            boolean result = service.isInRange(201, 100, 200);
            assertFalse(result, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testJustBeforeStart(TimeService service) {
        String testName = "Value just before start";
        try {
            // Range [100, 200), Value 99
            boolean result = service.isInRange(99, 100, 200);
            assertFalse(result, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    // ==================== Edge Cases & Boundaries ====================

    private void testStartEqualsEnd(TimeService service) {
        String testName = "Start equals End (Empty range)";
        try {
            // Range [100, 100), Value 100
            // No number can be >= 100 AND < 100
            boolean result = service.isInRange(100, 100, 100);
            assertFalse(result, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testStartGreaterThanEnd(TimeService service) {
        String testName = "Start greater than End (Invalid range)";
        try {
            // Range [200, 100), Value 150
            // Logic should handle invalid ranges gracefully (usually false)
            boolean result = service.isInRange(150, 200, 100);
            assertFalse(result, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testSinglePointRange(TimeService service) {
        String testName = "Single point range [10, 11)";
        try {
            // Only 10 should be true
            boolean result1 = service.isInRange(10, 10, 11);
            boolean result2 = service.isInRange(11, 10, 11);

            if (!result1 || result2) {
                throw new RuntimeException("Expected true for 10, false for 11");
            }
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    // ==================== Negative & Zero Values ====================
    private void testNegativeTimestamps(TimeService service) {
        String testName = "Negative timestamps range";
        try {
            // Range [-200, -100), Value -150
            boolean result = service.isInRange(-150, -200, -100);
            assertTrue(result, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testZeroTimestamps(TimeService service) {
        String testName = "Range starting at zero";
        try {
            // Range [0, 100), Value 0
            boolean result = service.isInRange(0, 0, 100);
            assertTrue(result, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCrossingZero(TimeService service) {
        String testName = "Range crossing zero";
        try {
            // Range [-50, 50), Value -10, 0, 49
            boolean r1 = service.isInRange(-10, -50, 50);
            boolean r2 = service.isInRange(0, -50, 50);
            boolean r3 = service.isInRange(49, -50, 50);
            boolean r4 = service.isInRange(50, -50, 50); // Should be false

            if (!r1 || !r2 || !r3 || r4) {
                throw new RuntimeException("Crossing zero logic failed");
            }
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    // ==================== Integer Limits ====================
    private void testMaxIntValues(TimeService service) {
        String testName = "Values near Integer.MAX_VALUE";
        try {
            int max = Integer.MAX_VALUE;
            // Range [max-10, max), Value max-5
            boolean result = service.isInRange(max - 5, max - 10, max);
            assertTrue(result, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testMinIntValues(TimeService service) {
        String testName = "Values near Integer.MIN_VALUE";
        try {
            int min = Integer.MIN_VALUE;
            // Range [min, min+10), Value min+5
            boolean result = service.isInRange(min + 5, min, min + 10);
            assertTrue(result, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testNearOverflow(TimeService service) {
        String testName = "End is MAX_VALUE, Start is MAX_VALUE-1";
        try {
            int max = Integer.MAX_VALUE;
            // Range [max-1, max)
            boolean r1 = service.isInRange(max - 1, max - 1, max); // True
            boolean r2 = service.isInRange(max, max - 1, max);     // False

            if (!r1 || r2) {
                throw new RuntimeException("Overflow boundary logic failed");
            }
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    // ==================== Helper Methods ====================
    private void assertTrue(boolean condition, String testName) {
        if (!condition) {
            throw new RuntimeException(testName + " FAILED: Expected true, got false");
        }
    }

    private void assertFalse(boolean condition, String testName) {
        if (condition) {
            throw new RuntimeException(testName + " FAILED: Expected false, got true");
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