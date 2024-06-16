package com.leetCode.binarySearch;

public class FirstBadVersion {
    public static void main(String[] args) {
        int n = 5;
        firstBadVersion(n);
    }

    public static int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static boolean isBadVersion(int n) {
        return true;

    }
}
