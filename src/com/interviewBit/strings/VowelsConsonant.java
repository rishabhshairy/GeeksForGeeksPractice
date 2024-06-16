package com.interviewBit.strings;

public class VowelsConsonant {
    public static void main(String[] args) {
        String s = "abec";
        System.out.println(solve(s));
    }

    static int solve(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')) {
                count++;
            }
        }
        return (int) ((count * (s.length() - count)) % (Math.pow(10, 9) + 7));
    }

}
