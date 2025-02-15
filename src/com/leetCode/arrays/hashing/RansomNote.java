package com.leetCode.arrays.hashing;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] mag = new int[26];


        for (char ch : magazine.toCharArray()) {
            mag[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            if (mag[ch - 'a'] == 0) {
                return false;
            }
            mag[ch - 'a']--;
        }
        return true;
    }
}
