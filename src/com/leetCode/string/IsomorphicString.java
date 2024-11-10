package com.leetCode.string;

public class IsomorphicString {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s, t));
    }

    private static boolean isIsomorphic(String s, String t) {
        int[] smap = new int[256];
        int[] tmap = new int[256];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (smap[s.charAt(i)] != tmap[t.charAt(i)]) {
                return false;
            }
            smap[s.charAt(i)] = i + 1;
            tmap[t.charAt(i)] = i + 1;
        }

        return true;
    }

    /**
     * This Approach will not work
     * As mapping equaL chars in both string will not suffice
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphicWrong(String s, String t) {
        char[] sChars = new char[256];
        char[] tChars = new char[256];

        for (int i = 0; i < s.length(); i++) {
            sChars[s.charAt(i)]++;
            tChars[t.charAt(i)]++;
        }

        int scount = 0;
        int tcount = 0;
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] > 0) {
                scount++;
            }
            if (tChars[i] > 0) {
                tcount++;
            }
        }

        return scount == tcount;
    }
}
