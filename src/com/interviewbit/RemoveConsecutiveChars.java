package com.interviewbit;

import java.util.HashMap;

public class RemoveConsecutiveChars {
    public static void main(String[] args) {
        String s = "aabcd";
        int n = 2;
        System.out.println(solve(s, n));
    }

    static String solve(String A, int B) {
        int n = A.length();
        String s = "";
        int i = 0;
        while (i < n) {
            StringBuilder temp = new StringBuilder();
            int j = i;
            while (j < n && A.charAt(i) == A.charAt(j)) {
                temp.append(A.charAt(j));

                j++;
            }
            if (temp.length() != B) {
                s = s + temp;
            }

            i = j;
        }
        return s;
    }
}
