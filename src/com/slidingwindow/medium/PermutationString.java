package com.slidingwindow.medium;

import java.util.Arrays;

public class PermutationString {

    /**
     * Optimal approach
     * --> Check if frequency of all chars in s1 is equals to s2
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1count = new int[26];
        int[] s2count = new int[26];

        // step 1 --> count freq upto length of s1
        for (int i = 0; i < s1.length(); i++) {
            s1count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1count,s2count)) {
            return true;
        }
        // now use sliding window to check s2count and see if it is equals to s2

        int left = 0;
        int right = s1.length();

        while (right < s2.length()) {

            // slide the window to make s2Count equal to s1count
            s2count[s2.charAt(left) - 'a']--;
            s2count[s2.charAt(right) - 'a']++;

            if (Arrays.equals(s1count, s2count)) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }
}
