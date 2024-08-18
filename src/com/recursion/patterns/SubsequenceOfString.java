package com.recursion.patterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsequenceOfString {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(findSubseqOfString(s));
    }

    public static List<String> findSubseqOfString(String s) {
        String sub = "";
        List<String> result = new ArrayList<>();
        int n = s.length();
        solve(0, sub, n, s, result);
        Collections.sort(result);
        return result;
    }

    private static void solve(int index, String sub, int n, String s, List<String> result) {
        if (index == n) {
            result.add(sub);
            return;
        }

        solve(index + 1, sub + s.charAt(index), n, s, result);
        solve(index + 1, sub, n, s, result);

    }
}
