package com.leetcode.array_string_stack;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinimumWindowSubstring windowSubstring = new MinimumWindowSubstring();
        System.out.println(windowSubstring.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (Character c :
                s.toCharArray()) {
            hm.put(c, 0);
        }

        for (Character c :
                t.toCharArray()) {
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c) + 1);
            } else {
                return "";
            }
        }
        int start = 0;
        int end = 0; // use this to find valid window.
        int counter = t.length();
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;

        char[] temp = s.toCharArray();

        while (end < s.length()) {
            char c1 = temp[end];
            if (hm.get(c1) > 0) {
                counter--;
            }
            hm.put(c1, hm.get(c1) - 1);
            end++;

            // below loop will run once valid window is found
            while (counter == 0) {
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }
                char c2 = temp[start];
                hm.put(c2, hm.get(c2) + 1);
                if (hm.get(c2) > 0) {
                    counter++;
                }
                start++;
            }
        }
        if (minLen != Integer.MAX_VALUE) {
            return s.substring(minStart, minStart + minLen);
        }
        return "";
    }
}
