package com.interviewbit;

public class AmazingSubarrays {
    public static void main(String[] args) {
        String s = "ABce";
        System.out.println(solve(s));
    }

    static int solve(String A) {
        int count = 0;
        int n = A.length();
        String s = A.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')) {
                count += (n - i);

            }
        }
        return (int) count % (10003);
    }
}
