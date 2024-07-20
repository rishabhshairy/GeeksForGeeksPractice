package com.leetCode.binarySearch;

/**
 * @author rshairy
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 */
public class SearchIn2D {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        //System.out.println(searchMatrixBruteForce(matrix, 3));
        //System.out.println(searchMatrixBetterApproach(matrix, 100));
        System.out.println(searchMatrix(matrix, 34));
    }

    /**
     * Check if target lies between 1st and last element of each row
     * if it exist do binary search on that element and return true
     * else check for next row
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrixBetterApproach(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][col - 1]) {
                return findTarget(matrix[i], target);
            }
        }

        return false;
    }

    private static boolean findTarget(int[] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (matrix[mid] == target) {
                return true;
            } else if (matrix[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static boolean searchMatrixBruteForce(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This is optimal approach
     * where we hypothetically convert 2D to 1D matrix
     * <p>
     * map the index to matrix[row][col]
     * <p>
     * row --> index / col
     * col --> index % col
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int low = 0;
        int high = (row * col) - 1; // assuming 1D matrix hypothetically

        while (low <= high) {
            int mid = (low + high) / 2;

            int mappedRow = mid / col;
            int mappedCol = mid % col;
            int mappedNumber = matrix[mappedRow][mappedCol];

            if (mappedNumber == target) {
                return true;
            } else if (mappedNumber > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return false;
    }
}
