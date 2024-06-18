package com.recursion.problems;

public class PalindromeCheck {
    public static void main(String[] args) {
        String s = "mAdaM";
        boolean b = checkPalindrome(s, 0, s.length());
        System.out.println(b);
    }

    private static boolean checkPalindrome(String s, int i, int n) {
        s = s.toLowerCase();

        if (i >= (n / 2)) {
            return true;
        }

        if (s.charAt(i) != s.charAt(n - i - 1)) {
            return false;
        }
        return checkPalindrome(s, i + 1, n);
    }

}
