package com.slidingwindow.medium;

import java.util.Arrays;

/**
 * GFG
 * Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.
 *
 */
public class CountAnagramsGFG {
    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";
        System.out.println(search(pat, txt));
    }



    static int search(String pat, String txt) {
        // code here
        int count = 0;
        int[] patCount = new int[26];
        for (int i = 0; i < pat.length(); i++) {
            patCount[pat.charAt(i) - 'a']++;
        }
        int txtCount[] = new int[26];
        int left = 0, right = 0;

        while (right < txt.length()) {
            txtCount[txt.charAt(right) - 'a']++;

            if (right - left + 1 == pat.length()) {
                if (Arrays.equals(patCount, txtCount)) {
                    count++;
                }
                txtCount[txt.charAt(left)-'a']--;
                left++;
                right++;
            }

            if (right - left + 1 < pat.length()) {
                right++;
            }
        }

        return count;
    }
}
