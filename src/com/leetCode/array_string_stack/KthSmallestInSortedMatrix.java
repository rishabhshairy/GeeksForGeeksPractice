package com.leetCode.array_string_stack;

import java.util.ArrayList;
import java.util.Collections;

public class KthSmallestInSortedMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        System.out.println(kthSmallest(mat, k));
    }

    static int kthSmallest(int[][] matrix, int k) {
        ArrayList<Integer> allNum = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                allNum.add(matrix[i][j]);
            }
        }

        Collections.sort(allNum);
        return allNum.get(k - 1);
    }
}
