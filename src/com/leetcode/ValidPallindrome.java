package com.leetcode;

import java.util.Locale;

public class ValidPallindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.print(isPalindrome(s));
    }

    static boolean isPalindrome(String s) {
        StringBuffer modifiedString = new StringBuffer();
        for (Character c :
                s.toCharArray()) {
            if (c.toString().matches("[a-zA-Z0-9]")) {
                modifiedString.append(c);
            }
        }

        return modifiedString.toString().toLowerCase().equals(modifiedString.reverse().toString().toLowerCase());
    }
}
