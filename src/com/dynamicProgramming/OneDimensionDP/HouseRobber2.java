package com.dynamicProgramming.OneDimensionDP;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2};
        System.out.println(houseRobber(arr));
    }

    /**
     * This Question is similar to house robber
     * Just we cannot rob last and first house
     * So answer can be in beteern (n-2 --> 0) or (n-1 --> 1)
     * following 0 based indexing
     * Just return max between 2 subarray of choice
     */

    public static long houseRobber(int[] valueInHouse) {
        // Write your code here
        if (valueInHouse.length == 1) {
            return valueInHouse[0];
        }
        long robFromLast = solveFromLast(valueInHouse, valueInHouse.length);
        long robFromSecondLast = solveFromSecondLast(valueInHouse, valueInHouse.length - 1);
        return Math.max(robFromLast, robFromSecondLast);
    }

    private static int solveFromSecondLast(int[] valueInHouse, int length) {
        int prev = valueInHouse[0]; // dp[0] or i-1
        int prev2 = 0;          // neg  or i-2

        for (int index = 1; index < length; index++) {
            int sumPick = valueInHouse[index];
            if (index > 1) {
                sumPick += prev2;
            }
            int sumNonPick = prev;
            int currSum = Math.max(sumPick, sumNonPick);
            prev2 = prev;
            prev = currSum;
        }
        return prev;
    }

    private static int solveFromLast(int[] valueInHouse, int length) {
        int prev = valueInHouse[1]; // dp[0] or i-1
        int prev2 = 0;          // neg  or i-2

        for (int index = 2; index < length; index++) {
            int sumPick = valueInHouse[index];
            sumPick += prev2;
            int sumNonPick = prev;
            int currSum = Math.max(sumPick, sumNonPick);
            prev2 = prev;
            prev = currSum;
        }
        return prev;
    }
}
