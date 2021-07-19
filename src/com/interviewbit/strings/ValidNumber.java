package com.interviewbit.strings;

public class ValidNumber {
    public static void main(String[] args) {
        String s = ".2";
        System.out.println(isNumber(s));
    }

    static int isNumber(final String s) {
        String mod = s.trim();
        String regex = "(-|\\+)?[0-9]*(\\.)?[0-9]+";
        String regex2 = "(-|\\+)?[e0-9]+";
        String regex3 = "(-|\\+)?[0-9]+(\\.)?[0-9]+[-e0-9]+";

        if (mod.matches(regex) || mod.matches(regex2) || mod.matches(regex3)) {
            return 1;
        }
        return 0;
    }
}
