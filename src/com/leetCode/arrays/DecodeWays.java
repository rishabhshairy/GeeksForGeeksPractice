package com.leetCode.arrays;

public class DecodeWays {
    public static void main(String[] args) {
        String toDecode = "12";
        System.out.println(numDecodings(toDecode));
    }

    static int numDecodings(String s) {
        int n = s.length();
        Integer[] mem = new Integer[n];
        return s.length() == 0 ? 0 : helper(s, 0, mem);
    }

    static int helper(String s, int index, Integer[] mem) {
        int n = s.length();
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (mem[index] != null) {
            return mem[index];
        }
        int answer = helper(s, index + 1, mem);
        if (index < n - 1 && (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) < '7'))) {
            answer += helper(s, index + 2, mem);
        }
        return mem[index] = answer;

    }
}
