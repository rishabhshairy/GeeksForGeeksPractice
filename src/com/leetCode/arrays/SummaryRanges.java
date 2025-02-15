package com.leetCode.arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 4, 6, 8, 9};
//        int[] arr = {0, 2, 5, 7, 9};
        SummaryRanges obj = new SummaryRanges();
        obj.summaryRanges(arr);
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int start = 0;
        boolean intervalStart = true;
        for (int i = 0; i < nums.length; i++) {
            start = nums[i];
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start != nums[i]) {
                result.add(start + "->" + nums[i]);
            } else {
                result.add("" + start);
            }
        }
//        System.out.println(result);
        return result;
    }
}
