package com.leetcode;

public class SmallerThanCurrent {
    public static void main(String[] args) {
        int[] test = {8, 1, 2, 2, 3};
        System.out.println(smallerNumbersThanCurrent(test));
    }

//    static int[] smallerNumbersThanCurrent(int[] nums) {
//        int[] answer = new int[nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            int count = 0;
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    count++;
//                }
//            }
//            answer[i] = count;
//        }
//        return answer;
//    }

    /*
     * O(n) solution using counting
     * */
    static int[] smallerNumbersThanCurrent(int[] nums) {
        var buck = new int[101];

        for (int i = 0; i < nums.length; i++)
            buck[nums[i]]++;                                // count each occurence

        for (int i = 1; i < buck.length; i++)
            buck[i] += buck[i - 1];                         // calc how manu numbers are smaller

        for (int i = 0; i < nums.length; i++)
            nums[i] = nums[i] == 0 ? 0 : buck[nums[i] - 1]; // fill resulting array

        return nums;
    }
}
