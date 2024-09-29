package com.dynamicProgramming.LIS;

import java.util.Arrays;
import java.util.Comparator;

public class DP45LongestStringChain {
    public static void main(String[] args) {
        String[] words = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        System.out.print(longestStrChain(words));
    }

    /**
     * Implementation to similar 1D LIS
     * Need to write compare function of
     *
     * @param words
     * @return
     */
    public static int longestStrChain(String[] words) {
        Comparator<String> stringComparator = (s1, s2) -> s1.length() - s2.length();
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;

        Arrays.sort(words, stringComparator);

        for (int index = 1; index < n; index++) {
            for (int prevInd = 0; prevInd < index; prevInd++) {
                if (compareStr(words[index], words[prevInd]) && 1 + dp[prevInd] > dp[index]) {
                    dp[index] = 1 + dp[prevInd];
                }
            }
            if (dp[index] > maxi) {
                maxi = dp[index];
            }
        }
        return maxi;
    }

    private static boolean compareStr(String word, String prevWord) {
        if (word.length() != prevWord.length() + 1) {
            return false;
        }

        int i = 0;
        int j = 0;
        while (i < word.length()) {
            if (j < prevWord.length() && word.charAt(i) == prevWord.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return i == word.length() && j == prevWord.length();
    }
}
