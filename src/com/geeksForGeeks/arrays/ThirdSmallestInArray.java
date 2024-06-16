package com.geeksForGeeks.arrays;

public class ThirdSmallestInArray {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 2, 5};
        findThirdSmallest(arr);
    }

    private static void findThirdSmallest(int[] arr) {
        int smallestVal = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int thirdSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (smallestVal > arr[i]) {
                thirdSmallest = secondSmallest;
                secondSmallest = smallestVal;
                smallestVal = arr[i];
            } else if (arr[i] < secondSmallest) {
                thirdSmallest = secondSmallest;
                secondSmallest = arr[i];
            } else if (arr[i] < thirdSmallest) {
                thirdSmallest = arr[i];
            }
        }

        System.out.println(thirdSmallest);
    }
}
