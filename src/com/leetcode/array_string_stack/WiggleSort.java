package com.leetcode.array_string_stack;

import java.util.Arrays;

public class WiggleSort {
    public static void main(String[] args) {
        int[] arr = {5, 5, 5, 4, 4, 4, 4};
        wiggleSort(arr);
        for (int a :
                arr) {
            System.out.println(a);
        }
    }

    static void wiggleSort(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        int n = arr.length - 1;
        for (int i = 1; i < arr.length; i += 2) {
            arr[i] = newArr[n--];
        }
        for (int i = 0; i < arr.length; i += 2) {
            arr[i] = newArr[n--];
        }

    }
}
