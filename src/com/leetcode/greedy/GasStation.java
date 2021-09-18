package com.leetcode.greedy;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int currGas = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            currGas += gas[i] - cost[i];

            if (currGas < 0) {
                totalGas += currGas;
                currGas = 0;
                start = i + 1;
            }
        }

        return totalGas + currGas >= 0 ? start : -1;
    }
}
