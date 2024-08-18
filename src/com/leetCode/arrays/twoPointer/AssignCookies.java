package com.leetCode.arrays.twoPointer;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies/description/
 */
public class AssignCookies {
    public static void main(String[] args) {

    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;
        int result = 0;

        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) {
                child++;
                cookie++;
                result++;
            } else {
                cookie++;
            }
        }

        return result;
    }
}
