package com.neetcode150.twoPointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "Was it a car or a cat I saw?";
        System.out.println(new ValidPalindrome().isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        int i = 0;
        int j = sb.length() - 1;
        System.out.println(sb);
        while (i < j) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
