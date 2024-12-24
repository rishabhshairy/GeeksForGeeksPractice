package com.slidingwindow.medium;

import java.util.HashMap;

/**
 * LC 2981
 */
public class LongestSpecialSubString {

    /**
     * Brute Force
     * Check all substring
     *
     * @param s
     * @return
     */
    public int maximumLength(String s) {
        int maxi = 0;
        HashMap<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {

                // Check is current substring is empty or it does contain special property
                if (sb.length() == 0 || sb.charAt(sb.length() - 1) == s.charAt(j)) {
                    sb.append(s.charAt(j));
                    countMap.put(sb.toString(), countMap.getOrDefault(sb.toString(), 0) + 1);
                } else {
                    break;
                }
            }
        }

        // now count substrings with val greater than 3
        for (String key : countMap.keySet()) {
            // check if map have value greater than 3 and length of key should be maximum
            if (countMap.get(key) >= 3 && key.length() > maxi) {
                maxi = key.length();
            }
        }

        return maxi == 0 ? -1 : maxi;
    }
}
