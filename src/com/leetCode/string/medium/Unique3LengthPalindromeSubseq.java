package com.leetCode.string.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Unique3LengthPalindromeSubseq {
    public static void main(String[] args) {
        String s = "aabca";
        System.out.println(countPalindromicSubsequence(s));
    }

    /**
     * Brute Force
     * Find all subsequence and then find palindromic of length 3
     *
     * @param s
     * @return
     */
    public static int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, Integer.MAX_VALUE);
        Arrays.fill(last, Integer.MIN_VALUE);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            first[ch - 'a'] = Math.min(i, first[ch - 'a']);
            last[ch - 'a'] = Math.max(i, last[ch - 'a']);
        }

        int result = 0;

        for (int i = 0; i < 26; i++) {
            // if char occurs only once do not count
            if (first[i] == Integer.MAX_VALUE || last[i] == Integer.MIN_VALUE) {
                continue;
            }

            Set<Character> uniqueCharacters = new HashSet<>();

            int firstIndex = first[i] + 1;
            int lastIndex = last[i];
            while (firstIndex < lastIndex) {
                uniqueCharacters.add(s.charAt(firstIndex));
                firstIndex++;
            }

            result += uniqueCharacters.size();
        }

        return result;
    }
}
