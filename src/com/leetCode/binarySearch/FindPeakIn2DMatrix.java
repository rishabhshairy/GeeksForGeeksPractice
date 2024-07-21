package com.leetCode.binarySearch;

/**
 * https://leetcode.com/problems/find-a-peak-element-ii/
 */
public class FindPeakIn2DMatrix {
    public static void main(String[] args) {

    }

    /**
     * Using binary search approach in this code
     *
     * @param mat
     * @return
     */
    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int low = 0;
        int high = col - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // find row number of max element in column
            int maxRowIndex = findMaxElementRow(mat, row, mid);

            //  now find left and right of column
            int left = mid - 1 >= 0 ? mat[maxRowIndex][mid - 1] : -1;
            int right = mid + 1 < col ? mat[maxRowIndex][mid + 1] : -1;

            // now apply binary search of peak element intuition
            int currPeak = mat[maxRowIndex][mid];

            if (left < currPeak && currPeak > right) {
                return new int[]{maxRowIndex, mid};
            } else if (currPeak < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * This function will return row number where the max element in that column
     *
     * @param mat
     * @param row
     * @param col
     * @return
     */
    private int findMaxElementRow(int[][] mat, int row, int col) {
        int maxi = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < row; i++) {
            if (mat[i][col] > maxi) {
                maxi = mat[i][col];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
