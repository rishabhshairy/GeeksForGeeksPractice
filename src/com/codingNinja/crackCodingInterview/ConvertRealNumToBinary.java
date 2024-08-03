package com.codingNinja.crackCodingInterview;

public class ConvertRealNumToBinary {
    public static void main(String[] args) {
        double num = 0.625;
        System.out.println(toBinaryCalculator(num));
    }

    public static String toBinaryCalculator(double num) {
        // Write Your Code here
        if (num > 1 || num <= 0) {
            return "ERROR";
        }
        String ans = "0.";

        while (num > 0) {
            if (ans.length() >= 32) {
                return "ERROR";
            }

            double x = 2 * num;
            if (x >= 1) {
                ans += "1";
                num = x - 1;
            } else {
                ans += "0";
                num = x;
            }
        }
        return ans;
    }
}
