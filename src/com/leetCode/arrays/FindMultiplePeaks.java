package com.leetCode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-the-peaks/description/
 */
public class FindMultiplePeaks {
    public static void main(String[] args) {
        System.out.println(findPeaks(new int[]{2, 4, 4}));
        System.out.println(findPeaks(new int[]{1, 4, 3, 8, 5}));
    }

    public static List<Integer> findPeaks(int[] mountain) {

        if (mountain.length == 3) {
            if (mountain[1] > mountain[0] && mountain[1] > mountain[2]) {
                return List.of(1);
            } else {
                return new ArrayList<>();
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                result.add(i);
            }
        }
        return result;
    }
}
