package com.slidingwindow.medium;

import java.util.Map;

/**
 * LC 1423
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
 */
public class MaxPointsFromCards {
    public static void main(String[] args) {
//        int[] points = {1, 2, 3, 4, 5, 6, 1};
        int[] points = {9,7,7,9,7,7,9};
        int k = 3;
        System.out.println(maxScore(points, 7));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int totalPoint = 0;
        int window = cardPoints.length - k;
        for (int points : cardPoints) {
            totalPoint += points;
        }

        if (window==0){
            return totalPoint;
        }

        int left = 0;
        int right = 0;

        int sum = 0, maxi = 0;

        while (right < cardPoints.length) {
            sum += cardPoints[right];

            if (right - left + 1 == window) {
                maxi = Math.max(maxi, totalPoint - sum);
                sum -= cardPoints[left++];
                right++;
            }
            if (right - left + 1 < window) {
                right++;
            }
        }
        return maxi;
    }
}
