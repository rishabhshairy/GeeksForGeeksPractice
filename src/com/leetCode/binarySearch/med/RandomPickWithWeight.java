package com.leetCode.binarySearch.med;

import java.util.Random;

public class RandomPickWithWeight {
    int[] weightSum;
    Random random;
    int totalSum;

    public static void main(String[] args) {
        int[] w = {1, 3, 5, 7};
        RandomPickWithWeight obj = new RandomPickWithWeight(w);
        System.out.println(obj.pickIndex());
    }

    public RandomPickWithWeight(int[] w) {
        random = new Random();
        weightSum = new int[w.length];
        int running = 0;
        for (int i = 0; i < w.length; i++) {
            running += w[i];
            weightSum[i] = running;
        }
        this.totalSum = running;
    }

    public int pickIndex() {
        if (this.totalSum == 0) {
            return -1;
        }
        int next = this.random.nextInt(this.totalSum) + 1; // +1 for binary search is 0 is there in array
        // using this next find index in weightSum where its less than the index

//        for (int i = 0; i < weightSum.length; i++) {
//            if (next < weightSum[i]) {
//                return i;
//            }
//        }

        // optimise using binary search
        int left = 0;
        int right = weightSum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (weightSum[mid] == next) {
                return mid;
            }
            if (weightSum[mid] < next) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
