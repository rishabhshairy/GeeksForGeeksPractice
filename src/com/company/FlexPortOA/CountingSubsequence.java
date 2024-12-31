package com.company.FlexPortOA;

import java.util.Arrays;
import java.util.HashMap;

public class CountingSubsequence {
    public static void main(String[] args) {
        int[] arr = {13, 11, 4, 12, 5, 4};
        CountingSubsequence obj = new CountingSubsequence();
        System.out.println(obj.countGoodSubsequence(arr));
    }

    private long countGoodSubsequence(int[] arr) {
        Arrays.sort(arr);
        int max = Arrays.stream(arr).max().getAsInt();
        int[] dp = new int[max + 1];

        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(countMap);

        /**
         * dp[i - 1]: The contribution from the previous number.
         * count[i] * dp[i - 1]: The value contributed by i when combined with the previous numbers.
         * count[i]: The value contributed by i on its own (standalone).
         */
        for (int num : arr) {
            if (countMap.containsKey(num)) {
                dp[num] = (countMap.get(num) * dp[num - 1]) + countMap.get(num);
                System.out.println(num + " :: dpVal=" + dp[num]);
            }
        }

        return Arrays.stream(dp).sum();
    }
}
