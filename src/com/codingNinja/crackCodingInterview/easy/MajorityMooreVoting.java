package com.codingNinja.crackCodingInterview.easy;

public class MajorityMooreVoting {
    public static void main(String[] args) {
        findMajority(new int[]{2, 2, 1, 1, 1, 2, 2}, 7);
    }

    public static int findMajority(int[] arr, int n) {

        /**
         * Writing Moore Voting Algorithm to find probable candidate
         */
        int count = 0;
        int probableElement = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                probableElement = arr[i];
            } else if (arr[i] == probableElement) {
                count++;
            } else {
                count--;
            }
            //System.out.println("Count = " + count + " :: probableElement = " + probableElement + " :: arrayEle = " + arr[i]);
        }

        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            if (probableElement == arr[i]) {
                totalCount++;
            }
        }

        return totalCount == arr.length / 2 ? probableElement : -1;
    }
}
