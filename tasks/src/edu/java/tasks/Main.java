package edu.java.tasks;

import edu.java.tasks.conditions.TimeServiceTest;
import edu.java.tasks.loops.DistanceServiceTest;
import edu.java.tasks.loops.WaterlineServiceTest;
import edu.java.tasks.util.Helper;
import edu.java.tasks.util.TestResults;

import java.util.List;

public class Main {
    static void main() {
        System.out.println("\t[You can run all tests separately by yourself]");

        List<TestResults> results = List.of(
                new TimeServiceTest().run(),
                new DistanceServiceTest().run(),
                new WaterlineServiceTest().run()
        );

        System.out.println("\n\n\n=== All tests results ===");
        results.forEach(Helper::printTestResults);
    }
}
