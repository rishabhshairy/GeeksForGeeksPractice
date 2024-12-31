package com.company.FlexPortOA;

import java.util.List;

public class SumOfAllValues {
    public static void main(String[] args) {
        String s = "9999999";
        long totalSum = 0;
        int n = s.length();

        for (int i = 0; i < Math.pow(2, n - 1); i++) {
            long sum = 0;
            String subset = "" + s.charAt(0);
            for (int index = 0; index < n - 1; index++) {
                // check if index is set i
                if (((i >> index) & 1) == 1) {
                    sum += Long.parseLong(subset);
                    subset = "" + s.charAt(index + 1);
                } else {
                    subset += s.charAt(index + 1);
                }

                if (index == n - 2) {
                    sum += Long.parseLong(subset);
                }
            }
            totalSum += sum;
        }

        System.out.println(totalSum);
    }
}
