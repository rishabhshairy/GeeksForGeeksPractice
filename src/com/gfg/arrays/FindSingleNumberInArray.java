package com.gfg.arrays;

public class FindSingleNumberInArray {
    public static void main(String[] args) {
        int[] arr = {7, 3, 3, 4, 5, 4, 5};
        findSingle(arr);
    }

    private static void findSingle(int[] arr) {
        int singleNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            singleNumber = singleNumber ^ arr[i];
        }
        System.out.println(singleNumber);
    }
}
