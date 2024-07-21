package com.leetCode.binarySearch;

import java.util.Arrays;

public class MedianInRowSortedMatrix {
    public static void main(String[] args) {

    }

    /**
     * This is optimal approach using binary search
     *
     * @param matrix
     * @param row
     * @param col
     * @return
     */
    int median(int matrix[][], int row, int col) {
        int low = minOfMatrix(matrix, row, 0);
        int high = maxOfMatrix(matrix, row, col - 1);

        int requiredElements = (row * col) / 2;

        while (low <= high) {
            int mid = (low + high) / 2;
            int smallOrEqualElements = countSmallEquals(matrix, row, col, mid);
            if (smallOrEqualElements <= requiredElements) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * @param matrix
     * @param row
     * @param col
     * @param mid
     * @return
     */
    private int countSmallEquals(int[][] matrix, int row, int col, int mid) {
        int count = 0;
        for (int i = 0; i < row; i++) {
            // find elements which are smaller than MID in each row
            count += upperBound(matrix[i], mid, col);
        }
        return count;
    }

    /**
     * @param matrix
     * @param mid
     * @param col
     * @return
     */
    private int upperBound(int[] matrix, int target, int col) {
        int low = 0;
        int high = matrix.length - 1;
        int ans = matrix.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    /**
     * Max value can be obtained from last column as the rows are sorted
     *
     * @param matrix
     * @param row
     * @param col
     * @return
     */
    private int maxOfMatrix(int[][] matrix, int row, int col) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            maxi = Math.max(maxi, matrix[i][col]);
        }
        return maxi;
    }

    /**
     * Min Value can be obtained from first column as rows are sorted
     *
     * @param matrix
     * @param row
     * @param col
     * @return
     */
    private int minOfMatrix(int[][] matrix, int row, int col) {
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            mini = Math.min(mini, matrix[i][col]);
        }
        return mini;
    }

    /**
     * Brute force here is to put all nums in array
     * Sort the 1D array
     * return arr[(rxc)/2]
     *
     * @param matrix
     * @param row
     * @param col
     * @return
     */
    int medianBruteForce(int matrix[][], int row, int col) {
        // code here
        int[] allNumbers = new int[row * col];
        int index = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                allNumbers[index++] = matrix[i][j];
            }
        }
        Arrays.sort(allNumbers);
        return allNumbers[(row * col) / 2];
    }
}
