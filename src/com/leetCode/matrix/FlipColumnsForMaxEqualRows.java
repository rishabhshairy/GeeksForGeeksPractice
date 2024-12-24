package com.leetCode.matrix;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaxEqualRows {

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        FlipColumnsForMaxEqualRows obj = new FlipColumnsForMaxEqualRows();
        obj.maxEqualRowsAfterFlips(mat);
    }

    /**
     * Simple hashmap approach
     * Store both the row and its flipped version in map
     * return max frequency in map
     * @param mat
     * @return
     */
    private int maxEqualRowsAfterFlips(int[][] mat) {
        Map<String, Integer> patternMap = new HashMap<>();

        for (int[] row : mat) {
            StringBuilder val = new StringBuilder();
            StringBuilder flippedVal = new StringBuilder();

            for (int bit : row) {
                val.append(bit);
                flippedVal.append(1 - bit);
            }

            patternMap.put(val.toString(), patternMap.getOrDefault(val.toString(), 0) + 1);
            patternMap.put(flippedVal.toString(), patternMap.getOrDefault(flippedVal.toString(), 0) + 1);
        }
        return Collections.max(patternMap.values());
    }

    /**
     * Hash Map Approach
     *
     * @param mat
     * @return
     */
    private int maxEqualRowsAfterFlipsEditorial(int[][] mat) {
        HashMap<String, Integer> patternMap = new HashMap<>();

        for (int[] row : mat) {
            StringBuilder pattern = new StringBuilder();
            if (row[0] == 0) {
                // append each bit of row as-is
                for (int bit : row) {
                    pattern.append(bit);
                }
            } else {

                // append complement of bit
                for (int bit : row) {
                    pattern.append(bit ^ 1);
                }
            }
            patternMap.merge(pattern.toString(), 1, Integer::sum);
        }
        return Collections.max(patternMap.values());
    }

    /**
     * Trying out brute Force approach
     * invert each row and compare with original one
     *
     * @param matrix
     * @return
     */
    public int maxEqualRowsAfterFlipsBruteForce(int[][] matrix) {
        int cols = matrix[0].length;
        int maxRows = 0;

        for (int[] row : matrix) {

            int[] flippedRow = new int[cols];
            int count = 0;

            // creating flipped version of current row
            for (int i = 0; i < cols; i++) {
                flippedRow[i] = 1 - row[i];
            }

            for (int[] compareRow : matrix) {
                if (Arrays.equals(compareRow, row) || Arrays.equals(compareRow, flippedRow)) {
                    count++;
                }
            }
            maxRows = Math.max(maxRows, count);
        }
        return maxRows;
    }
}


