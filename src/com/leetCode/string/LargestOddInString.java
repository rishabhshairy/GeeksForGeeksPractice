package com.leetCode.string;

public class LargestOddInString {
    public static void main(String[] args) {
        String s = "4206";
        System.out.println(largestOddNumber(s));
    }


    /**
     * Better Approach check last digit of number if it's odd
     */

    private static String largestOddNumber(String s) {
        int n = s.length();
        if ((int) s.charAt(n - 1) % 2 != 0) {
            return s;
        }

        int index = n - 1;
        while (index >= 0) {
            int lastDigit = s.charAt(index);
            if (lastDigit % 2 != 0) {
                return s.substring(0, index + 1);
            }
            index--;
        }
        return "";
    }

    /**
     * This approach is giving TLE
     *
     * @param num
     * @return
     */
    public static String largestOddNumberTLE(String num) {
        long max = Long.MIN_VALUE;

        for (int i = num.length() - 1; i >= 0; i--) {
            long maxOdd = Long.parseLong(num.substring(0, i + 1));
            if (maxOdd % 2 != 0) {
                max = Math.max(maxOdd, max);
            }
        }
        return max == Long.MIN_VALUE ? "" : String.valueOf(max);
    }
}
