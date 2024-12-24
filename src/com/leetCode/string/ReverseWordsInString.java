package com.leetCode.string;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();

        int left = 0;
        int right = split.length - 1;
        while (left < right) {
            String temp = split[left];
            split[left] = split[right];
            split[right] = temp;
            left++;
            right--;
        }

        for (String ss :
                split) {
            if (ss.length() > 0) {
                sb.append(ss).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
