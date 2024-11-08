package com.slidingwindow.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LC 658
 * Given a sorted integer array arr, two integers k and x,
 * return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * <p>
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 */
public class FindKClosest {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        new FindKClosest().findClosestElements(arr, 3, 5);
    }

    /**
     * Approach --> find the floor of X  in array using BS
     * <p>
     * then left =  floorIndex
     * right = left+1
     *
     * now apply the rule till left >=0 and right < n
     *
     * add left out elements from left and right
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = findLowerBound(arr, x);
        int right = left + 1;
//        System.out.println(arr[left]);
        List<Integer> result = new ArrayList<>();

        while (k > 0 && left >= 0 && right < arr.length) {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                result.add(arr[left--]);
            } else {
                result.add(arr[right++]);
            }
            k--;
        }

        // add left out elements
        while (k > 0 && left >= 0) {
            result.add(arr[left--]);
            k--;
        }

        while (k > 0 && right < arr.length) {
            result.add(arr[right++]);
            k--;
        }

        Collections.sort(result);
//        System.out.print(result);
        return result;
    }

    private int findLowerBound(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] < x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
