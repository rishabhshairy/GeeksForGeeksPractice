package com.codingNinja.crackCodingInterview.easy;

public class NinjaAndInfiniteArray {
    public static void main(String[] args) {
        InfinteSizeArray obj = new InfinteSizeArray(new int[]{1, 3, 5, 7, 9, 11});
        System.out.println(ninjaAndInfiniteSizeArray(obj,12));
    }

    public static int ninjaAndInfiniteSizeArray(InfinteSizeArray obj, int target) {
        // Write your code here.
        int low = 0;
        int high = 4999;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (obj.readValueAtIndex(mid) == target) {
                return mid;
            }
            if (obj.readValueAtIndex(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

class InfinteSizeArray {
    private int[] arr;
    private int size;

    InfinteSizeArray(int[] arr) {
        size = arr.length;
        this.arr = arr;
    }

    public int readValueAtIndex(int index) {
        if (index >= size) {
            return (int) Math.pow(10, 9) + 7;
        } else {
            return arr[index];
        }
    }
}