package com.leetCode.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNum {
    public String largestNumber(int[] nums) {
        String ans = Arrays.stream(nums).
                mapToObj(String::valueOf).
                sorted((a, b) -> (b + a).compareTo(a + b)).
                collect(Collectors.joining(""));
        return ans.startsWith("00") ? "0" : ans;
    }
}
