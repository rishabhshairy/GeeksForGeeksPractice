package com.leetCode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC2800ShortestStringContainingThreeString {
    public static void main(String[] args) {
        String a = "abc", b = "bca", c = "aaa";
        System.out.println(minimumString(a, b, c));
    }

    /**
     * Trying out brute force
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static String minimumString(String a, String b, String c) {
        String res = "";
        int longest = Integer.MAX_VALUE;
        for (String s : new String[]
                {
                        merge(merge(a, b), c),
                        merge(merge(b, a), c),
                        merge(merge(c, b), a),
                        merge(merge(b, c), a),
                        merge(merge(a, c), b),
                        merge(merge(c, a), b),
                }
        ) {
            if (s.length() < longest) {
                res = s;
                longest = s.length();
            } else if (s.length() == longest) {
                res = res.compareTo(s) < 0 ? res : s;
            }
        }
        return res;
    }

    private static String merge(String s1, String s2) {
        if (s1.contains(s2)) {
            return s1;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s2.startsWith(s1.substring(i))) {
                //System.out.println(s1.substring(0, i) + s2);
                return s1.substring(0, i) + s2;
            }
        }
        return s1 + s2;
    }
}
