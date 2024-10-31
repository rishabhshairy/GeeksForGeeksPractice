package com.neetcode150.twoPointers;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
//        int[][] numIndex = new int[numbers.length][2];
//
//        for (int i = 0; i < numbers.length; i++) {
//            numIndex[i][0] = i;
//            numIndex[i][1] = numbers[i];
//        }

        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
