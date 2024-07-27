package com.dynamicProgramming.TwoDimensionDP;

import java.util.Arrays;

/**
 * https://www.naukri.com/code360/problems/ninja-s-training_3621003
 * GFG --> https://www.geeksforgeeks.org/problems/geeks-training/1
 */
public class NinjaTraining {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int n = 3;
        System.out.println(ninjaTraining(n, arr));
    }

    /**
     * First writing the recursive solution
     *
     * @param n
     * @param points
     * @return
     */
    public static int ninjaTrainingRecursion(int n, int points[][]) {

        int days = points.length - 1;
        int totalTasks = points[0].length;

        return solveRecurrence(days, totalTasks, points);

    }

    private static int solveRecurrence(int currDay, int lastTask, int[][] points) {

        // base condition when we reach 0th day
        if (currDay == 0) {
            int maxi = -1;
            for (int task = 0; task < 3; task++) {
                if (task != lastTask) {
                    maxi = Math.max(maxi, points[currDay][task]);
                }
            }
            return maxi;
        }

        int maxPoints = Integer.MIN_VALUE;

        for (int task = 0; task < 3; task++) {
            if (task != lastTask) {
                int currPoints = points[currDay][task] + solveRecurrence(currDay - 1, task, points);
                maxPoints = Math.max(maxPoints, currPoints);
            }
        }

        return maxPoints;
    }


    /**
     * Memoization solution --> top down
     *
     * @param n
     * @param points
     * @return
     */
    public static int ninjaTrainingMemo(int n, int points[][]) {
        int days = points.length;
        int totalTasks = points[0].length;
        int[][] dp = new int[days][totalTasks + 1];

        // fill dp array with -1
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveMemo(days - 1, totalTasks, points, dp);
    }

    private static int solveMemo(int currDay, int lastTask, int[][] points, int[][] dp) {
        // base condition when we reach 0th day
        if (currDay == 0) {
            int maxi = -1;
            for (int task = 0; task < 3; task++) {
                if (task != lastTask) {
                    maxi = Math.max(maxi, points[currDay][task]);
                }
            }
            return maxi;
        }

        if (dp[currDay][lastTask] != -1) {
            return dp[currDay][lastTask];
        }
        int maxPoints = Integer.MIN_VALUE;

        for (int task = 0; task < 3; task++) {
            if (task != lastTask) {
                int currPoints = points[currDay][task] + solveMemo(currDay - 1, task, points, dp);
                maxPoints = Math.max(maxPoints, currPoints);
            }
        }

        return dp[currDay][lastTask] = maxPoints;
    }

    /**
     * Tabulation
     *
     * @param n
     * @param points
     * @return maxPoints
     */
    public static int ninjaTrainingTabulation(int n, int points[][]) {
        int days = points.length;
        int totalTasks = points[0].length;
        int[][] dp = new int[days][totalTasks + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        // For Base Case
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int currDay = 1; currDay < days; currDay++) {
            // each day will have 3 choice of task
            for (int lastTask = 0; lastTask < totalTasks + 1; lastTask++) {

                dp[currDay][lastTask] = 0; // for calculating max points
                // now iterating through current task
                for (int currTask = 0; currTask < 3; currTask++) {
                    if (currTask != lastTask) {
                        int currPoints = points[currDay][currTask] + dp[currDay - 1][currTask];
                        dp[currDay][lastTask] = Math.max(currPoints, dp[currDay][lastTask]);
                    }
                }
            }
        }
        return dp[n - 1][3];
    }

    /**
     * Space optimization of tabulated answer
     *
     * @param n
     * @param points
     * @return
     */
    public static int ninjaTraining(int n, int points[][]) {
        int days = points.length;
        int totalTasks = points[0].length;
        int[] dp = new int[4];
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int currDay = 1; currDay < days; currDay++) {
            // each day will have 3 choice of task

            // Initialize an array 'temp' to store the maximum points for the current day
            int temp[] = new int[4];

            for (int lastTask = 0; lastTask < totalTasks + 1; lastTask++) {

                temp[lastTask] = 0; // for calculating max points
                // now iterating through current task
                for (int currTask = 0; currTask < 3; currTask++) {
                    if (currTask != lastTask) {
                        int currPoints = points[currDay][currTask] + dp[currTask];
                        temp[lastTask] = Math.max(currPoints, temp[lastTask]);
                    }
                }
            }
            // update temp to dp
            dp = temp;
        }
        return dp[3];
    }
}
