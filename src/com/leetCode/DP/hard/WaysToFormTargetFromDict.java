package com.leetCode.DP.hard;

import java.util.Arrays;

public class WaysToFormTargetFromDict {
    public static void main(String[] args) {
        String[] words = {"acca", "bbbb", "caca"};
        String target = "aba";
        WaysToFormTargetFromDict obj = new WaysToFormTargetFromDict();
        System.out.println(obj.numWays(words, target));
    }

    public int numWays(String[] words, String target) {
        int[][] dp = new int[words[0].length() + 1][target.length() + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(words, target, 0, 0, dp);
    }

    private int solve(String[] words, String target, int wordIndex, int targetIndex, int[][] dp) {
        if (targetIndex == target.length()) {
            return 1;
        }

        if (dp[wordIndex][targetIndex] != -1) {
            return dp[wordIndex][targetIndex];
        }

        // edge cases
        // 1 reached end of 1st word in dictionary
        // 2 Not able to form even first char with the first word of dict
        if (wordIndex == words[0].length() || words[0].length() - wordIndex < target.length() - targetIndex) {
            return 0;
        }

        long count = 0;

        // iterating over all words
        for (int index = 0; index < words.length; index++) {
            if (words[index].charAt(wordIndex) == target.charAt(targetIndex)) {
                count += solve(words, target, wordIndex + 1, targetIndex + 1, dp) % 1000000007;
            }
        }
        count += solve(words, target, wordIndex + 1, targetIndex, dp) % 1000000007;
        return dp[wordIndex][targetIndex] = (int) (count % 1000000007);
    }
}
