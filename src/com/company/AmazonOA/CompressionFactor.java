package com.company.AmazonOA;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CompressionFactor {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] factor = {1, 2, 1};
        int x = 2;

        PriorityQueue<Integer> pqRow;
        PriorityQueue<Integer> maxElements = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < mat.length; i++) {
            pqRow = new PriorityQueue<>(Comparator.reverseOrder());
            for (int j = 0; j < mat.length; j++) {
                pqRow.offer(mat[i][j]);
            }

            // now only take elements till factor[i]
            for (int factorIndex = 0; factorIndex < factor[i]; factorIndex++) {
                maxElements.add(pqRow.poll());
            }
        }
        System.out.println(maxElements);
        int sum=0;
        while (x-->0){
            sum+=maxElements.poll();
        }
        System.out.println(sum);
    }
}
