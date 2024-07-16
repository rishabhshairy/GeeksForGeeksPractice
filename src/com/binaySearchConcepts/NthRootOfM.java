package com.binaySearchConcepts;

/**
 * GFG Problem
 * https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1
 * You are given 2 numbers (n , m); the task is to find n√m (nth root of m).
 */
public class NthRootOfM {
    public static void main(String[] args) {
        System.out.println(NthRoot(3, 9));
    }

    public static int NthRoot(int n, int m) {
        // code here
        if (n == 1) {
            return m;
        }
        int ans = -1;
        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = (low + high) / 2;

            int nthRoot = (int) Math.pow(mid, n);
            if (nthRoot == m){
                return mid;
            }
            else if (nthRoot < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
