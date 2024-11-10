package com.leetCode.string;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagramCharApproach(s, t));
    }

    static boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc, tc);
    }

    /**
     * @param s
     * @param t
     * @return
     */
    static boolean isAnagramCharApproach(String s, String t) {
        int[] sChar = new int[256];
        int[] tChar = new int[256];

        for (int i = 0; i < s.length(); i++) {
            sChar[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            tChar[t.charAt(i)]++;
        }

        // now check char counts
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] != tChar[i]) {
                return false;
            }
        }
        return true;
    }
}
