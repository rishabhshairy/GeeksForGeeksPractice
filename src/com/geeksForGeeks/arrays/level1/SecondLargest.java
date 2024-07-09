package com.geeksForGeeks.arrays.level1;

import java.util.Arrays;
import java.util.List;

public class SecondLargest {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(10, 10);
        System.out.println(print2largest(arr));
    }

    public static int print2largest(List<Integer> arr) {
        if (arr.size() == 0 || arr.size() == 1) {
            return -1;
        }
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int i;
        for (i = 0; i < arr.size(); i++) {
            smallest = Math.min(arr.get(i), smallest);
            largest = Math.max(arr.get(i), largest);
        }

        for (i = 0; i < arr.size(); i++) {
            if (arr.get(i) < secondSmallest && arr.get(i) != smallest) {
                secondSmallest = arr.get(i);
            }
            if (arr.get(i) > secondLargest && arr.get(i) != largest) {
                secondLargest = arr.get(i);
            }
        }
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
}
