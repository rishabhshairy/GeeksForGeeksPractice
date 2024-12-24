package com.leetCode.string;

public class MaxNestingOfParanthesis {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        maxDepth(s);
    }

    public static int maxDepth(String s) {
        int maxLen = Integer.MIN_VALUE;
        int count = 0;

        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                maxLen = Math.max(maxLen, count);
                count--;
            }
        }
        System.out.print(maxLen);
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
