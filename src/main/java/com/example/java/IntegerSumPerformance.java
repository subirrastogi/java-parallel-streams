package com.example.java;

import java.util.stream.IntStream;

import static com.example.java.StreamBenchMarks.xqtFunctions;

public class IntegerSumPerformance {

    public static int seqSumRangeClosed(int n) {
        return IntStream.rangeClosed(1, n)
                        .sum();
    }

    public static int paraSumRangeClosed(int n) {
        return IntStream.rangeClosed(1, n)
                        .parallel()
                        .sum();
    }


    public static void main(String[] args) {
        System.out.println("Streams created with the rangeClosed() method:");
        System.out.println(" Size Sequential Parallel");
        xqtFunctions(IntegerSumPerformance::seqSumRangeClosed,
                IntegerSumPerformance::paraSumRangeClosed);

        System.out.println("Iterative solution with an explicit loop:");

        System.out.println(" Size Iterative");
        xqtFunctions(IntegerSumPerformance::iterSumLoop);

        System.out.println("All Times are in milliseconds");

    }

    private static int iterSumLoop(int n) {
        int result = 0;
        for (int i = 1; i <=n; i++) {
            result+= i;
        }

        return result;
    }
}
