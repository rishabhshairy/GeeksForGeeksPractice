package com.leetCode.greedy.medHard;

import java.util.Arrays;

public class ShortestJobFirst {
    public static void main(String[] args) {
        int[] bt = {4, 3, 7, 1, 2};
        solve(bt);
    }

    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int[] waitTime = new int[bt.length];
        waitTime[0] = 0;
        for (int i = 1; i < bt.length; i++) {
            int currWaitTime = bt[i - 1];
            waitTime[i] = waitTime[i - 1] + currWaitTime;

        }
        return Arrays.stream(waitTime).sum() / bt.length;
    }
}
