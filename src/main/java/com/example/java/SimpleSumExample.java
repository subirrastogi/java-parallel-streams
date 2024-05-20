package com.example.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SimpleSumExample {
    public static void main(String[] args) {

        int sum = Arrays.stream(new int[]{1, 2, 3, 4})  // (1)
                        .parallel()                     // (2)
                        .sum();                         // (3)

        System.out.println("Sum - " + sum);
    }
}
