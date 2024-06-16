package com.geeksForGeeks.strings;

public class CountOfSubStringHavingUniqChar {
    public static void main(String[] args) {
        String s = "gffg";
        int n = s.length();

        int i = 0, j = 0;
        int[] count = new int[26];
        int ans = 0;

        while (i < n) {
            if (j < n && count[s.charAt(j) - 'a'] == 0) {
                System.out.println(s.charAt(j) - 'a');
                count[s.charAt(j) - 'a']++;
                ans += (j - i + 1);
                j++;
            } else {
                count[s.charAt(i) - 'a']--;
                i++;
            }
        }
    }
}
