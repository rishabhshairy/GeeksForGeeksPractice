package com.leetCode.heaps;

import java.util.*;

/**
 * Nutanix OA
 */
public class RankWithLevelUp {
    public static void main(String[] args) {
        int k = 737;
        int[] scores = new int[10000];
        Random rand = new Random();

        for (int i = 0; i < scores.length; i++) {
            scores[i] = rand.nextInt(100); // Generates numbers between 0 and 100 (inclusive)
        }

        System.out.println("k = " + k);
        System.out.println("Scores: " + Arrays.toString(scores));
        findPlayers(k, scores);
    }

    public static int findPlayers(int k, int[] scores) {
        int n = scores.length;
        int[] ranks = new int[n];
        Arrays.sort(scores);
        Map<Integer, int[]> numMap = new TreeMap<>();

        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (scores[i] > 0) {
                if (!numMap.containsKey(scores[i])) {
                    numMap.put(scores[i], new int[]{rank, 1});
                } else {
                    int[] curr = numMap.get(scores[i]);
                    curr[1]++;
                    numMap.put(scores[i], curr);
                }
                rank++;
            }
        }
        int count = 0;
        for (int key : numMap.keySet()) {
            if (numMap.get(key)[0] <= k) {
                count += numMap.get(key)[1];
            }
        }
        System.out.println(count);
        return count;
    }
}
