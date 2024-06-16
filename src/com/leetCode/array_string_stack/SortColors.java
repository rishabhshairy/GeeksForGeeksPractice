package com.leetCode.array_string_stack;

public class SortColors {
    public static void main(String[] args) {
        int[] test = {2, 0, 2, 1, 1, 0};
        sortColors(test);
    }

    static void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int k=0;
        for (int i = 0; i < count[0]; i++) {
            nums[k++]=0;
        }
        for (int i = 0; i < count[1]; i++) {
            nums[k++]=1;
        }
        for (int i = 0; i < count[2]; i++) {
            nums[k++]=2;
        }
    }
}
