package com.slidingwindow.hard;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueChars {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        System.out.println(longestkSubstr(s, 3));
    }

    public static int longestkSubstr(String s, int k) {
        // code here
        Map<Character, Integer> charMap = new LinkedHashMap<>();

        int left = 0, right = 0, n = s.length(), maxi = Integer.MIN_VALUE;

        while (right < n) {
            charMap.put(s.charAt(right), charMap.getOrDefault(s.charAt(right), 0) + 1);

            if (charMap.size() < k) {
                right++;
            } else if (charMap.size() == k) {
                maxi = Math.max(maxi, right - left + 1);
                right++;

            } else if (charMap.size() > k) {

                while (charMap.size() > k) {
                    charMap.put(s.charAt(left), charMap.get(s.charAt(left)) - 1);
                    if (charMap.get(s.charAt(left)) == 0) {
                        charMap.remove(s.charAt(left));
                    }
                    left++;
                }
                right++;
            }

        }
        return maxi == Integer.MIN_VALUE ? -1 : maxi;
    }
}
