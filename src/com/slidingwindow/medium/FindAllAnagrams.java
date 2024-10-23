package com.slidingwindow.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC438
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams
 * in s. You may return the answer in any order.
 */
public class FindAllAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(new FindAllAnagrams().findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String txt, String pat) {
        List<Integer> result = new ArrayList<>();

        int[] patCount = new int[26];
        for (int i = 0; i < pat.length(); i++) {
            patCount[pat.charAt(i) - 'a']++;
        }
        int[] txtCount = new int[26];
        int left = 0, right = 0;

        while (right < txt.length()) {
            txtCount[txt.charAt(right) - 'a']++;

            if (right - left + 1 == pat.length()) {
                if (Arrays.equals(patCount, txtCount)) {
                    result.add(left);
                }
                txtCount[txt.charAt(left) - 'a']--;
                left++;
                right++;
            }

            if (right - left + 1 < pat.length()) {
                right++;
            }
        }
        return result;
    }
}
