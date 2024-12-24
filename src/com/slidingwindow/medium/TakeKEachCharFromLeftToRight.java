package com.slidingwindow.medium;

public class TakeKEachCharFromLeftToRight {
    public static void main(String[] args) {
        String s = "aabaaaacaabc";
        System.out.println(takeCharacters(s, 2));
    }

    public static int takeCharacters(String s, int k) {
        int[] freq = new int[3];
        for (Character ch : s.toCharArray()) {
            freq[ch - 'a']++;

        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0 || freq[i] < k) {
                return -1;
            }
        }

        int left = 0;
        int right = 0;
        int res = Integer.MAX_VALUE;

        while (right < s.length()) {
            char ch = s.charAt(right);
            freq[ch - 'a']--;

            // check if min of any one in freq is less than K
            while (Math.min(freq[0], Math.min(freq[1], freq[2])) < k) {
                freq[s.charAt(left) - 'a']++;
                left++;
            }
            res = Math.min(res, s.length() - (right - left + 1));
            right++;
        }

        return res;
    }
}
