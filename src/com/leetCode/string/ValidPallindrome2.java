package com.leetCode.string;

public class ValidPallindrome2 {
    public static void main(String[] args) {
        String s = "abca";
        ValidPallindrome2 validPallindrome2 = new ValidPallindrome2();
        System.out.println(validPallindrome2.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            };
        }

        return false;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
