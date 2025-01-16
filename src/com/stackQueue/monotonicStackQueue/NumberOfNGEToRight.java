package com.stackQueue.monotonicStackQueue;

import java.util.Stack;

public class NumberOfNGEToRight {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1};
        int queries = 2;
        int[] indices = {0, 3};
        int[] ngEs = count_NGEs(arr.length, arr, queries, indices);
        for (int num : ngEs) {
            System.out.print(num + " ");
        }
    }

    public static int[] count_NGEs(int N, int[] arr, int queries, int[] indices) {
        // code here
        int[] result = new int[indices.length];
        int j = 0;
        for (int queryIndex : indices) {
            int count = 0;
            for (int i = queryIndex + 1; i < N; i++) {
                if (arr[i] > arr[queryIndex]) {
                    count++;
                }
            }
            result[j] = count;
            j++;
        }
        return result;
    }
}
