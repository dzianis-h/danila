package edu.java.tasks.util;

public class Helper {
    public static void printTestResults(TestResults results) {
        System.out.printf("\n=== Test Summary [%s] ===\n", results.testName());
        System.out.println("Tests passed: " + results.passed());
        System.out.println("Tests failed: " + results.failed());
        System.out.println("Total tests: " + results.total());
    }
}
