package com.leetCode.arrays;

import java.util.*;

public class IntersectionOfArrays2 {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        intersect(num1, num2);
    }

    static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> setMap = new HashMap<>();

        for (Integer num :
                nums1) {
            if (setMap.containsKey(num)) {
                setMap.put(num, setMap.get(num) + 1);
            } else {
                setMap.put(num, 1);
            }

        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer num :
                nums2) {
            if (setMap.containsKey(num) && setMap.get(num) > 0) {
                list.add(num);
                setMap.put(num, setMap.get(num) - 1);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
