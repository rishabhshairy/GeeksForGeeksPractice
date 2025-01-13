package com.leetCode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-length-of-string-after-operations/description/
 */
public class MinLengthAfterOperaations {
    public static void main(String[] args) {
        String s = "abaacbcbb";
        System.out.println(minimumLengthOptimal(s));
    }

    private static int minimumLengthOptimal(String s) {
        if (s.length() <= 2) {
            return s.length();
        }
        int[] freq = new int[26];
        for (Character ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int f : freq) {
            System.out.print(f + " ");
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] <= 2) {
                continue;
            } else {
                if (freq[i] % 2 == 0) {
                    while (freq[i] > 2) {
                        freq[i]--;
                    }
                } else {
                    while (freq[i] > 1) {
                        freq[i]--;
                    }
                }

            }
        }
        System.out.println();
        for (int f : freq) {
            System.out.print(f + " ");
        }
        return Arrays.stream(freq).sum();
    }

    public static int minimumLength(String s) {
        if (s.length() <= 2) {
            return s.length();
        }

        Map<Character, Integer> charMap = new HashMap<>();

        for (Character c :
                s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        //System.out.println(charMap);
        int minLength = 0;
        for (Character currChar :
                charMap.keySet()) {
            int charCount = charMap.get(currChar);
            if (charCount > 2) {

                if (charCount % 2 == 0) {
                    minLength += (charCount - (charCount - 2));
                } else {
                    minLength += (charCount - (charCount - 1));
                }
            } else {
                minLength += charCount;
            }
        }
        return minLength;
    }
}
