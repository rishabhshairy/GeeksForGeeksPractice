package com.slidingwindow.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s consisting only of characters a, b and c.
 * <p>
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 */
public class CountSubstringWithAllChars {

    public static void main(String[] args) {
//        System.out.println(numberOfSubstrings("abcabc"));
    }

    /**
     * Optimal solution
     * Count a,b,c while moving
     * and for each window check if count of them is > 1
     *
     * @param s
     * @return
     */
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, count = 0;

        while (right < s.length()) {
            char key = s.charAt(right);
            map.put(key, map.getOrDefault(key, 0) + 1);

            while (map.getOrDefault('a', 0) > 0
                    && map.getOrDefault('b', 0) > 0
                    && map.getOrDefault('c', 0) > 0) {
                count += s.length() - right;
                key = s.charAt(left);
                map.put(key, map.get(key) - 1);
                left++;

            }
            right++;
        }
        return count;
    }

    /**
     * Brute Force Solution
     * TLE
     *
     * @param s
     * @return
     */
    public static int numberOfSubstringsBruteForce(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (sub.contains("a") && sub.contains("b") && sub.contains("c")) {
                    count++;
                }
            }
        }
        return count;
    }
}
