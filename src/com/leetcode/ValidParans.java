package com.leetcode;

public class ValidParans {
    public static void main(String[] args) {
        String s = "((*)";
        checkValidString(s);
    }

    public static boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char ch :
                s.toCharArray()) {
            lo += ch == '(' ? 1 : -1;
            hi += ch != ')' ? 1 : -1;
            if (hi < 0) {
                break;
            }
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }
}
