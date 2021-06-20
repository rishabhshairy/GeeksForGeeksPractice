package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountNumberSmaller {
    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        for (Integer a :
                countSmaller(nums)) {
            System.out.println(a);
        }

    }
/*    // O(n^2) solution
    static List<Integer> countSmaller(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int count = 0;
            int[] nextElem = Arrays.copyOfRange(nums, i + 1, nums.length);
            Arrays.sort(nextElem);
            for (int j = 0; j < nextElem.length; j++) {
                if (nums[i] > nextElem[j]) {
                    count++;
                } else {
                    break;
                }
            }
            answer.add(count);
        }
        answer.add(0);
        return answer;
    }*/

    static List<Integer> countSmaller(int[] nums) {
        List<Integer> sortVisit = new ArrayList<>();

        // keeping this array to fill from back
        int[] countArr = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            countArr[i] = binarySearch(nums[i], 0, sortVisit.size(), sortVisit);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < countArr.length; i++) {
            answer.add(countArr[i]);
        }
        return answer;
    }

    private static int binarySearch(int currNo, int start, int end, List<Integer> sortVisit) {
        int mid = (start + end) / 2;

        if (start >= end) {
            sortVisit.add(mid, currNo);
            return mid;
        }

        if (currNo > sortVisit.get(mid)) {
            return binarySearch(currNo, mid + 1, end, sortVisit);
        } else {
            return binarySearch(currNo, start, mid, sortVisit);
        }


    }
}
