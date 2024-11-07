package com.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow(s, t));

    }

    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) return "";

        int[] hash = new int[256];

        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }

        int counter = 0;
        int startIndex = -1;
        int minLen = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;

        while (right < s.length()) {

            // if same character is found
            if (hash[s.charAt(right)] > 0) {
                counter++;
            }

            hash[s.charAt(right)]--;

            while (counter == t.length()) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                hash[s.charAt(left)]++;
                // re-inserted into map
                if (hash[s.charAt(left)] > 0) {
                    counter--;
                }
                left++;
            }

            right++;
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
