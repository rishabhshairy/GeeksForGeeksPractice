package com.leetCode.backtracking;

public class FindPunishmentNumber {
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int sqr = i * i;
            if (canPartition(sqr, i)) {
                res += sqr;
            }
        }
        return res;
    }

    private boolean canPartition(int num, int target) {
        if (num < target || target < 0) {
            return false;
        }

        if (num == target) {
            return true;
        }
        // solve(quotient, target - remainder)
        return (canPartition(num / 10, target - (num % 10)) ||
                canPartition(num / 100, target - (num % 100)) ||
                canPartition(num / 1000, target - (num % 1000)));
    }
}
