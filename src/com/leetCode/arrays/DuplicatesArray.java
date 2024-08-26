package com.leetCode.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesArray {
    public static void main(String[] args) {
        int a[]={4,3,2,7,8,2,3,1};
    }
    static List<Integer> findDuplicates(int[] nums) {
        List<Integer> answerList=new ArrayList<>();
        Set<Integer> dupSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (dupSet.contains(nums[i])){
                answerList.add(nums[i]);
            } else {
                dupSet.add(nums[i]);
            }
        }
        return answerList;
    }
}
