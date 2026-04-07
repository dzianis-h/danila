package edu.java.tasks.util;

public record TestResults(
        int passed,
        int failed,
        String testName
) {
    int total() {
        return passed + failed;
    }
}
