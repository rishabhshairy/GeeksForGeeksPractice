package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfString {
    public static void main(String[] args) {
        String s = "eadbccdaeeabdeadbccdaeeabd";
        System.out.println(permute(s, 0, s.length() - 1));
    }

    private static boolean isPallindrome(String permStr) {
        int i = 0;
        int j = permStr.length() - 1;
        System.out.println(permStr);
        while (i <= j) {
            if (permStr.charAt(i++) != permStr.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    private static boolean permute(String s, int start, int end) {
        if (start == end) {
            if (isPallindrome(s)) {
                System.out.println("pallindrome");
                return true;
            }
        }

        for (int index = start; index <= end; index++) {
            s = swap(s, index, start);
            permute(s, start + 1, end);
            s = swap(s, index, start);
        }
        return false;
    }

    private static String swap(String s, int index, int start) {
        char temp;
        char[] tempArr = s.toCharArray();
        temp = tempArr[index];
        tempArr[index] = tempArr[start];
        tempArr[start] = temp;
        return String.valueOf(tempArr);
    }
}
