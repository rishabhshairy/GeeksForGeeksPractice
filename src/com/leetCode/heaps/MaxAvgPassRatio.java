package com.leetCode.heaps;

import java.util.PriorityQueue;

/**
 * LC 1792
 */
public class MaxAvgPassRatio {
    public static void main(String[] args) {
        int[][] classes = {{2, 4}, {3, 9}, {4, 5}, {2, 10}};
        MaxAvgPassRatio obj = new MaxAvgPassRatio();
        System.out.println(obj.maxAverageRatio(classes, 4));
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {

        PriorityQueue<double[]> classQueue = new PriorityQueue<double[]>((x, y) -> Double.compare(y[2], x[2]));

        for (int[] cls : classes) {
            int passes = cls[0];
            int total = cls[1];
            double gainRatio = calculateGain(passes, total);
            classQueue.offer(new double[]{passes, total, gainRatio});
        }

        while (extraStudents > 0) {
            double[] currClass = classQueue.poll();

            int passes = (int) currClass[0];
            int total = (int) currClass[1];

            classQueue.offer(new double[]{passes + 1, total + 1, calculateGain(passes + 1, total + 1)});
            extraStudents--;
        }

        double res = 0;

        while (!classQueue.isEmpty()) {
            double[] currClass = classQueue.poll();
            int pass = (int) currClass[0];
            int total = (int) currClass[1];
            res += (double) pass / total;
        }

        return res / classes.length;
    }

    private double calculateGain(int p, int t) {
        return ((double) (p + 1) / (t + 1) - (double) p / t);
    }


}
