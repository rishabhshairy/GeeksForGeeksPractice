package com.leetCode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-length-of-string-after-operations/description/
 */
public class MinLengthAfterOperaations {
    public static void main(String[] args) {
        String s = "abaacbcbb";
        System.out.println(minimumLength(s));
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
