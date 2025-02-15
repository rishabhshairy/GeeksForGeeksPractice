package com.leetCode.string;

public class OneSwapToMakeEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int first = -1;
        int second = -1;
        int count = 0;

        int n = s1.length();

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count == 1) {
                    first = i;
                } else if (count == 2) {
                    second = i;
                } else {
                    return false;
                }
            }

        }

        return count == 2 && s1.charAt(first) == s2.charAt(second) && s2.charAt(first) == s1.charAt(second);
    }
}
