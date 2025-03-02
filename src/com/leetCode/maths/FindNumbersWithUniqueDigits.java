package com.leetCode.maths;

public class FindNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        int result = 10; // if n==1 total answer will be 10
        int unique = 9; // since we can have only 9 unique digits
        int total = 9; // total unique combination can be 9

        while (n-- > 1 && total > 0) {
            unique = unique * total;
            result += unique; // add result to unique
            total--;
        }
        return result;
    }
}
