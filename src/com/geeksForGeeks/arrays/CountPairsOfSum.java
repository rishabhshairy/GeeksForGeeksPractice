package com.geeksForGeeks.arrays;

import java.util.HashMap;

public class CountPairsOfSum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 1};
        System.out.println(getPairsCount(arr, arr.length, 6));
    }

    static int getPairsCount(int[] arr, int n, int k) {
        // code here
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], 0);
            }
            hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (hashMap.get(k - arr[i]) != null) {
                count += hashMap.get(k - arr[i]);
            }

            if (k-arr[i]==arr[i]){
                count--;
            }
        }
        return count / 2;
    }
}
