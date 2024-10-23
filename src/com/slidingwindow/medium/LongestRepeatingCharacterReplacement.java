package com.slidingwindow.medium;

import java.util.Arrays;

/**
 * LC 424
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */
public class LongestRepeatingCharacterReplacement {

    /**
     * HashMap Solution
     * tc --> O(2N)
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int[] hash = new int[26];
        int left = 0;
        int right = 0;
        int maxFreq = 0;

        while (right < s.length()) {
            int charIndex = s.charAt(right) - 'A';
            hash[charIndex]++;
            maxFreq = Math.max(maxFreq, hash[charIndex]);

            // first checking negative condition to shrink the window
//            while ((right - left + 1) - maxFreq > k) {
               if ((right - left + 1) - maxFreq > k){
                // shrink the window
                // reduce s[left] frequency
                int leftIndex = s.charAt(left) - 'A';
                hash[leftIndex]--;
                // below increases the complexity
//                for (int i = 0; i < hash.length; i++) {
//                    maxFreq = Math.max(maxFreq, hash[i]);
//                }
                left++;
            }
            int currWindow = right - left + 1;
            int changes = currWindow - maxFreq;

            if (changes <= k) {
                maxLen = Math.max(maxLen, currWindow);
            }
            right++;
        }
        return maxLen;
    }

    /**
     * Brute Force solution
     * try all substring
     * changes = currenWindow - maxFreqOfChar
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacementBruteForce(String s, int k) {
        int maxLen = 0;
        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(hash, 0);
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                hash[s.charAt(j)]++;
                maxFreq = Math.max(maxFreq, hash[s.charAt(j)]);
                int currWindow = j - i + 1;
                int changes = currWindow - maxFreq;
                if (changes <= k) {
                    maxLen = Math.max(maxLen, currWindow);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }
}
