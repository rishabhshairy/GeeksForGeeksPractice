package com.september.challenge;

import java.util.HashSet;
import java.util.Set;

public class ArrayNesting {
    public static void main(String[] args) {
        int[] arr = {5, 4, 0, 3, 1, 6, 2};
    }

    public int arrayNesting(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> answer = new HashSet<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            int k = nums[i];
            while (!answer.contains(k)) {
                answer.add(k);
                k = nums[k];
                temp++;
            }
            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }


}
