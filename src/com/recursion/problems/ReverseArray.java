package com.recursion.problems;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

//        swapUsingTwoPointers(0, arr, 0, arr.length - 1);
        swapUsingSinglePointer(arr, 0, arr.length);
        // print reversed array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * Functional approach using single pointer
     */

    public static void swapUsingSinglePointer(int[] arr, int i, int n) {
        if (i >= (n / 2)) {
            return;
        }
        swapNumbers(arr, i, n - i - 1);
        swapUsingSinglePointer(arr, i + 1, n);
    }

    /**
     * @author rshairy
     * This is two  pointer approach
     */
    public static void swapUsingTwoPointers(int index, int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        swapNumbers(arr, l, r);
        swapUsingTwoPointers(index, arr, l + 1, r - 1);
    }

    /**
     * Generic function to swap numbers
     * @author rshairy
     * @param arr
     * @param l
     * @param r
     */
    private static void swapNumbers(int[] arr, int l, int r) {
        int num = arr[l];
        arr[l] = arr[r];
        arr[r] = num;
    }
}
