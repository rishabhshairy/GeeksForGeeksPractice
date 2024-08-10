package com.codingNinja.crackCodingInterview.easy;

/**
 *
 */
public class PalindromePermutation {

    public static void main(String[] args) {
        String s = "aabbc";
        palindromeString(s);
    }

    public static boolean palindromeString(String s) {
        // Write your code here.
        int[] count = new int[26];
        for (char c :
                s.toCharArray()) {
            count[c - 'a']++;
        }
        int odd = 0;
        for (int x :
                count) {
            odd += x & 1;
        }
        return odd < 2;
    }
}
