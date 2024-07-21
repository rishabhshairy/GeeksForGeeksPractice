package com.geeksForGeeks.arrays.binarySearch;

public class RowWithMaxOnes {
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1, 1}};
        System.out.println(rowWithMax1s(arr));
    }

    public static int rowWithMax1s(int arr[][]) {
        // code here
        int maxOnes = 0;
        int indexAns = -1;
        int row = arr.length;
        int col = arr[0].length;

        for (int i = 0; i < row; i++) {
            int currOne = col - findLowerBound(arr[i], 1);
            //System.out.println(currOne);
            if (currOne > maxOnes) {
                maxOnes = currOne;
                indexAns = i;
            }
        }
        return indexAns;
    }

    public static int findLowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length; // setting hypothetical answer if we dont find any such number

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
