package com.leetCode.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBinaryString {
    public static void main(String[] args) {
        System.out.println(generateBinaryStrings(3));
    }

    public static List<String> generateBinaryStrings(int n) {
        // code here
        List<String> binaryStrings = new ArrayList<>();
        char[] sb = new char[n];
        solve(0, n, sb, binaryStrings);
        return binaryStrings;
    }

    private static void solve(int index, int n, char[] sb, List<String> binaryStrings) {
        if (index == n) {
            binaryStrings.add(String.valueOf(sb));
            return;
        } else if (index > 0 && sb[index - 1] == '1') {
            sb[index] = '0';
            solve(index + 1, n, sb, binaryStrings);
        } else {
            sb[index] = '0';
            solve(index + 1, n, sb, binaryStrings);
            sb[index] = '1';
            solve(index + 1, n, sb, binaryStrings);
        }
    }
}
