package com.example.java;

import java.util.function.IntFunction;

public class StreamBenchMarks {

    /*
       Reference - https://blogs.oracle.com/javamagazine/post/java-parallel-streams-performance-benchmark
     */

    /*
     * Applies the function parameter func, passing n as parameter.
     * Returns the average time (ms.) to execute the function 100 times.
     */
    public static <R> double measurePerf(IntFunction<R> func, int n) {
        int numOfExecutions = 100;
        double totTime = 0.0;
        R result = null;
        for (int i = 0; i < numOfExecutions; i++) {
            double start = System.nanoTime();
            result = func.apply(n);
            double duration = (System.nanoTime() - start)/1_000_000;
            totTime += duration;
        }
        double avgTime = totTime/numOfExecutions;
        return avgTime;
    }

    /*
     * Executes the functions in the vararg funcs for different stream sizes.
     */

    public static <R> void xqtFunctions(IntFunction<R>... funcs) {
        int[] sizes = {1_000, 10_000, 100_000, 1_000_000};

        for (int i = 0; i < sizes.length; ++i) {
            System.out.printf("%7d", sizes[i]);

            // ... execute the functions passed in the var-arg funcs.

            for (int j = 0; j < funcs.length; ++j) {
                System.out.printf("%10.5f", measurePerf(funcs[j], sizes[i]));
            }

            System.out.println();
        }
    }
}
