package com.leetCode.string.medium;

import java.util.Arrays;

public class SubstringWithKDistinctChar {
    public static void main(String[] args) {

    }

    /**
     * Using approach of Atmost K chars - atmost (k-1) chars
     *
     * @param S
     * @param K
     * @return
     */
    long substrCount(String S, int K) {
        // your code here
        long countAtMostK = solve(S, K);
        long countAtMostKLess1 = solve(S, K - 1);

        return countAtMostK - countAtMostKLess1;

    }

    private long solve(String s, int k) {
        int[] freq = new int[26];
        long count = 0;

        // now use sliding window
        int left = 0;
        int right = 0;
        int n = s.length();
        int distinctCount = 0;

        while (right < n) {
            int charIndex = s.charAt(right) - 'a';
            freq[charIndex]++;

            if (freq[charIndex] == 1) {
                distinctCount++;
            }

            // now slide the window if distinct character is beyond K
            while (distinctCount > k) {
                freq[s.charAt(left) - 'a']--;

                // check if char at left is 0 in freq table
                // then reduce distinct count
                if (freq[s.charAt(left) - 'a'] == 0) {
                    distinctCount--;
                }
                left++;
            }
            // calculate current window
            count += (right - left + 1);
            right++;
        }
        return count;
    }

    /**
     * Brute Force
     * TC -->O(n*n)
     * SC --> O(1)
     *
     * @param S
     * @param K
     * @return
     */
    long substrCountBruteForce(String S, int K) {
        // your code here
        boolean[] freq = new boolean[26];
        long count = 0;

        for (int i = 0; i < S.length(); i++) {
            int distCount = 0;
            Arrays.fill(freq, false);
            for (int j = i; j < S.length(); j++) {
                if (!freq[S.charAt(j) - 'a']) {
                    distCount++;
                }
                freq[S.charAt(j) - 'a'] = true;

                if (distCount == K) {
                    count++;
                }
            }
        }
        return count;
    }
}
