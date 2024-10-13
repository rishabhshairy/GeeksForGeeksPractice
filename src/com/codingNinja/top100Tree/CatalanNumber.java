package com.codingNinja.top100Tree;

public class CatalanNumber {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(findCatalan(n));
    }


    private static int findCatalanRecursive(int n) {
        int res = 0;

        if (n <= 1) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            res += findCatalanRecursive(i) * findCatalanRecursive(n - i - 1);
        }
        return res;
    }

    /**
     * Writing tabulation method
     */

    private static long findCatalan(int n) {
        long[] dp = new long[n + 2];

        if (n <= 1) {
            return 1;
        }

        dp[0] = 1;
        dp[1] = 1;

        long res = 0;
        for (int i = 2; i <= n; i++) {
            dp[i]=0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }


}
