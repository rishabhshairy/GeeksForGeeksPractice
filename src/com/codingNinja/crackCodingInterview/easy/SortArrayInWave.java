package com.codingNinja.crackCodingInterview.easy;

public class SortArrayInWave {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 5, 4, 1};
        waveFormArray(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] waveFormArray(int[] arr, int n) {
        // Write your code here.
        /**
         * Logic is to start from i=1 and compare with i-1 and i+1
         */

        for (int i = 1; i < n; i += 2) {

            // Checking for i-1
            if (arr[i] > arr[i - 1]) {
                swap(arr, i, i - 1);
            }
            if (i < n - 1 && arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
