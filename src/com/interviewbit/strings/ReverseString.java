package com.interviewbit.strings;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        String s = "qxkpvo  f   w vdg t wqxy ln mbqmtwwbaegx   mskgtlenfnipsl bddjk znhksoewu zwh bd fqecoskmo";
        System.out.println(solve(s));
    }

    static String solve(String A) {
        String modify = A.trim();
        String[] allWords = modify.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = allWords.length - 1; i >= 0; i--) {
            if (allWords[i].length() > 0 && !allWords[i].equals(" ")) {
                sb.append(allWords[i].trim());
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
