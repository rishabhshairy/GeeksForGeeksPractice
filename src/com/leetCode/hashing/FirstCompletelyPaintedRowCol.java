package com.leetCode.hashing;

import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPaintedRowCol {
    public static void main(String[] args) {
        int[] arr = {2, 8, 7, 4, 1, 3, 5, 6, 9};
        int[][] mat = {{3, 2, 5}, {1, 4, 6}, {8, 7, 9}};
        System.out.println(firstCompleteIndex(arr, mat));
    }

    /**
     * Approach
     * Take map to store the position of elements in matrix
     * take 2 arr freq for row and col of each size
     * traverse from 1 - m*n and increment freq of row and col
     *
     * @param arr
     * @param mat
     * @return
     */
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> matPositionMap = new HashMap<>();
        int row = mat.length;
        int col = mat[0].length;

        int[] rowFreq = new int[row];
        int[] colFreq = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matPositionMap.put(mat[i][j], new int[]{i, j});
            }
        }

        for (int i = 0; i < row * col; i++) {
            // find current position from elements in arr
            int[] currPos = matPositionMap.get(arr[i]);
            int currRow = currPos[0];
            int currCol = currPos[1];

            // increment and check freq of row and column if count is same to rowSize and colSize return i
            if (++rowFreq[currRow] == row) {
                return i;
            }
            if (++colFreq[currCol]==col){
                return i;
            }
        }

        return 0;
    }
}
