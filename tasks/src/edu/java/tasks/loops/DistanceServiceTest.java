package edu.java.tasks.loops;

import edu.java.tasks.util.TestResults;

import java.util.Arrays;
import java.util.stream.Collectors;

import static edu.java.tasks.util.Helper.printTestResults;

public class DistanceServiceTest {
    private final static double tolerance = 0.00001;
    private final String testName = this.getClass().getSimpleName();

    private int testsPassed = 0;
    private int testsFailed = 0;

    public static void main() {
        printTestResults(new DistanceServiceTest().run());
    }

    public TestResults run() {
        DistanceService service = new DistanceService();

        System.out.printf("\n=== Test Starting %s ===\n\n", testName);
        System.out.println("=== Testing calcLength ===");
        testCalcLengthEmpty(service);
        testCalcLengthSingleElement(service);
        testCalcLengthSingleElementNegative(service);
        testCalcLengthTwoElements(service);
        testCalcLengthThreeElements(service);
        testCalcLengthFourElements(service);
        testCalcLengthNegativeValues(service);
        testCalcLengthMixedZeros(service);
        testCalcLengthAllZeros(service);
        testCalcLengthLargeValues(service);
        testVeryLongVector(service);

        System.out.println("\n=== Testing calcDistance ===");
        testCalcDistanceSamePoint(service);
        testDifferenceLengthPoints(service);
        testCalcDistanceOneDimensional(service);
        testCalcDistanceTwoDimensional(service);
        testCalcDistanceThreeDimensional(service);
        testCalcDistanceNegativeCoordinates(service);
        testCalcDistanceMixedSigns(service);
        testCalcDistanceZeroDistanceDifferentPoints(service);
        testCalcDistanceLargeValues(service);
        testCalcDistanceNonOriginStart(service);

        return new TestResults(testsPassed, testsFailed, testName);
    }

    // ==================== calcLength Tests ====================

    private void testCalcLengthEmpty(DistanceService service) {
        String testName = "Empty array";
        try {
            double result = service.calcLength(new double[]{});
            assertClose(result, 0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCalcLengthSingleElement(DistanceService service) {
        String testName = "Single element vector";
        try {
            double result = service.calcLength(new double[]{3.0});
            assertClose(result, 3.0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCalcLengthSingleElementNegative(DistanceService service) {
        String testName = "Single negative element";
        try {
            double result = service.calcLength(new double[]{-4.0});
            assertClose(result, 4.0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCalcLengthTwoElements(DistanceService service) {
        String testName = "Two-dimensional vector (3, 4)";
        try {
            double result = service.calcLength(new double[]{3.0, 4.0});
            assertClose(result, 5.0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCalcLengthThreeElements(DistanceService service) {
        String testName = "Three-dimensional vector (1, 2, 2)";
        try {
            double result = service.calcLength(new double[]{1.0, 2.0, 2.0});
            assertClose(result, 3.0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCalcLengthFourElements(DistanceService service) {
        String testName = "Four-dimensional vector (1, 1, 1, 1)";
        try {
            double result = service.calcLength(new double[]{1.0, 1.0, 1.0, 1.0});
            assertClose(result, 2.0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCalcLengthNegativeValues(DistanceService service) {
        String testName = "Vector with negative components (-3, -4)";
        try {
            double result = service.calcLength(new double[]{-3.0, -4.0});
            assertClose(result, 5.0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCalcLengthMixedZeros(DistanceService service) {
        String testName = "Vector with zeros (0, 5, 0)";
        try {
            double result = service.calcLength(new double[]{0.0, 5.0, 0.0});
            assertClose(result, 5.0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCalcLengthAllZeros(DistanceService service) {
        String testName = "All zeros vector (0, 0, 0)";
        try {
            double result = service.calcLength(new double[]{0.0, 0.0, 0.0});
            assertClose(result, 0.0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCalcLengthLargeValues(DistanceService service) {
        String testName = "Large values vector (100, 100)";
        try {
            double result = service.calcLength(new double[]{100.0, 100.0});
            assertClose(result, Math.sqrt(20000), testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testVeryLongVector(DistanceService service) {
        var vector = new double[]{481.623, 450.248, 637.306, 593.385, 484.45, 163.222, 848.369, 782.218, 93.02, 587.976, 657.433, 74.97, 436.242, 467.413, 544.951, 651.095, 585.031, 702.109, 145.632, 760.428, 713.038, 181.207, 449.629, 140.351, 223.831, 126.834, 273.246, 514.768, 938.19, 86.965, 793.501, 162.627, 426.315, 366.34, 974.098, 117.306, 242.876, 358.189, 650.277, 273.453, 882.587, 521.549, 226.475, 417.1, 691.903, 326.05, 611.518, 120.348, 367.79, 512.715, 463.502, 530.878, 794.779, 757.005, 321.837, 900.785, 278.159, 43.581, 486.146, 604.924, 374.088, 578.532, 22.402, 518.064, 226.83, 937.662, 480.988, 207.603, 682.637, 573.816, 29.829, 760.829, 714.907, 391.459, 718.328, 350.663, 690.925, 771.635, 288.366, 992.25, 548.412, 148.795, 906.456, 730.231, 191.442, 223.971, 835.965, 832.81, 651.645, 649.975, 704.994, 138.015, 328.318, 403.968, 788.415, 732.122, 28.053, 130.94, 42.555, 759.65};
        String testName = Arrays.stream(vector)
                .mapToObj(Double::toString)
                .collect(Collectors.joining(", ", "Very long vector (", ")"));
        try {
            double result = service.calcLength(vector);
            assertClose(result, 5484.304068902636, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    // ==================== calcDistance Tests ====================

    private void testCalcDistanceSamePoint(DistanceService service) {
        String testName = "Same point distance";
        try {
            double result = service.calcDistance(new double[]{1.0, 2.0}, new double[]{1.0, 2.0});
            assertClose(result, 0.0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testDifferenceLengthPoints(DistanceService service) {
        String testName = "Difference length points";
        try {
            double result = service.calcDistance(new double[]{5.0, 4.0}, new double[]{1.0, 2.0, 3.0});
            assertClose(result, 0.0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCalcDistanceOneDimensional(DistanceService service) {
        String testName = "One-dimensional distance";
        try {
            double result = service.calcDistance(new double[]{-1.0}, new double[]{5.0});
            assertClose(result, 6.0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCalcDistanceTwoDimensional(DistanceService service) {
        String testName = "Two-dimensional distance (0,0) to (3,4)";
        try {
            double result = service.calcDistance(new double[]{0.0, 0.0}, new double[]{3.0, 4.0});
            assertClose(result, 5.0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCalcDistanceThreeDimensional(DistanceService service) {
        String testName = "Three-dimensional distance (1,2,3) to (4,6,8)";
        try {
            double result = service.calcDistance(new double[]{1.0, 2.0, 3.0},
                    new double[]{4.0, 6.0, 8.0});
            // sqrt((4-1)^2 + (6-2)^2 + (8-3)^2) = sqrt(9 + 16 + 25) = sqrt(50)
            assertClose(result, Math.sqrt(50), testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCalcDistanceNegativeCoordinates(DistanceService service) {
        String testName = "Negative coordinates (-1,-1) to (-4,-5)";
        try {
            double result = service.calcDistance(new double[]{-1.0, -1.0},
                    new double[]{-4.0, -5.0});
            // sqrt((-4+1)^2 + (-5+1)^2) = sqrt(9 + 16) = 5
            assertClose(result, 5.0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCalcDistanceMixedSigns(DistanceService service) {
        String testName = "Mixed signs (-3, 4) to (5, -2)";
        try {
            double result = service.calcDistance(new double[]{-3.0, 4.0},
                    new double[]{5.0, -2.0});
            // sqrt((5+3)^2 + (-2-4)^2) = sqrt(64 + 36) = 10
            assertClose(result, 10.0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCalcDistanceZeroDistanceDifferentPoints(DistanceService service) {
        String testName = "Zero distance with same coordinates";
        try {
            double result = service.calcDistance(new double[]{0.0, 0.0, 0.0},
                    new double[]{0.0, 0.0, 0.0});
            assertClose(result, 0.0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCalcDistanceLargeValues(DistanceService service) {
        String testName = "Large coordinate values";
        try {
            double result = service.calcDistance(new double[]{0.0, 0.0},
                    new double[]{1000.0, 1000.0});
            assertClose(result, Math.sqrt(2000000), testName);
            pass(testName);
        } catch (Exception | AssertionError e) {
            fail(testName, e.getMessage());
        }
    }

    private void testCalcDistanceNonOriginStart(DistanceService service) {
        String testName = "Distance not from origin (1,1) to (4,5)";
        try {
            double result = service.calcDistance(new double[]{1.0, 1.0},
                    new double[]{4.0, 5.0});
            // sqrt((4-1)^2 + (5-1)^2) = sqrt(9 + 16) = 5
            assertClose(result, 5.0, testName);
            pass(testName);
        } catch (Exception e) {
            fail(testName, e.getMessage());
        }
    }

    // ==================== Helper Methods ====================
    private void assertClose(double actual, double expected, String testName) {
        if (Math.abs(actual - expected) > tolerance) {
            throw new RuntimeException(
                    String.format("%s FAILED: Expected %.6f, got %.6f (tolerance: %f)",
                            testName, expected, actual, tolerance)
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