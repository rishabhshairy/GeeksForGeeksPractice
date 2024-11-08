package com.slidingwindow.medium;

import java.util.Arrays;
import java.util.HashSet;

public class LongestSubStringWithoutRepChars {

    /**
     * Using 2pointer and sliding window
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int len = 0;
        int[] hash = new int[255];
        Arrays.fill(hash, -1);

        if (n == 0) {
            return 0;
        }

        while (right < n) {

            // already visited
            if (hash[s.charAt(right)] != -1) {
                // move left pointer one index ahead of repeating character's current position
                if (hash[s.charAt(right)] >= left) {
                    left = hash[s.charAt(right)] + 1;
                }
            }
            len = right - left + 1;
            maxLen = Math.max(len, maxLen);
            hash[s.charAt(right)] = right;
            right++;
        }

        return maxLen;
    }

    /**
     * Brute force approach
     * form all substring and find if prev char was repeated
     * TC --> o(N^2)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringBF(String s) {
        int[] hash = new int[255];
        int maxi = Integer.MIN_VALUE;
        int len = 0;
        if (s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(hash, 0);
            for (int j = i; j < s.length(); j++) {
                if (hash[s.charAt(j)] == 1) {
                    //maxi = Math.max(maxi, j-i+1);
                    break;
                }
                len = j - i + 1;
                maxi = Math.max(maxi, len);
                hash[s.charAt(j)] = 1;
            }
        }
        return maxi;
    }
}
