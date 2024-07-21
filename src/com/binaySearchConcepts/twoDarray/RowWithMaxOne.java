package com.binaySearchConcepts.twoDarray;

import java.util.ArrayList;

public class RowWithMaxOne {
    public static void main(String[] args) {

    }

    public static int rowMaxOnesBruteForce(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int row = n;
        int col = m;
        int maxOnes = Integer.MIN_VALUE;
        int ansIndex = -1;

        for (int i = 0; i < row; i++) {
            int currOne = 0;

            for (int j = 0; j < col; j++) {
                if (mat.get(i).get(j) == 1) {
                    currOne++;
                }
            }
            // Update answer
            if (currOne > maxOnes) {
                maxOnes = currOne;
                ansIndex = row;
            }

        }

        return maxOnes;
    }


    /**
     * @param mat
     * @param n
     * @param m
     * @return
     */
    public static int rowMaxOnesUsingLowerBound(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int maxOnes = -1;
        int indexAns = -1;
        // go through each row
        for (int i = 0; i < n; i++) {
            int totalOnesInRow = m - findLowerBound(mat.get(i), 1);

            if (maxOnes < totalOnesInRow) {
                maxOnes = totalOnesInRow;
                indexAns = i;
            }
        }
        return indexAns;
    }

    /**
     * Use lower bound to find index where 1 starts
     *
     * @param arr
     * @param target
     * @return
     */

    public static int findLowerBound(ArrayList<Integer> arr, int target) {
        int low = 0;
        int high = arr.size() - 1;
        int ans = arr.size(); // setting hypothetical answer if we dont find any such number

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr.get(mid) >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
