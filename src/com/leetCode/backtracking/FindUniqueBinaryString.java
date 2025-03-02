package com.leetCode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindUniqueBinaryString {

    /**
     * Cantor's Diagonal Algorithm
     *
     * @param nums
     * @return
     */
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }

    /**
     * This is recursive solution
     *
     * @param nums
     * @return
     */
    public String findDifferentBinaryStringRecursive(String[] nums) {
        Set<String> unique = new HashSet<>();
        List<String> allBinaries = new ArrayList<>();
        int n = nums.length;
        for (String s :
                nums) {
            unique.add(s);
        }
        char[] binary = new char[n];
        solve(0, n, binary, unique, allBinaries);
        return allBinaries.get(0);
    }

    private void solve(int index, int n, char[] binary, Set<String> unique, List<String> allBinaries) {
        if (index == n) {
            if (!unique.contains(String.valueOf(binary))) {
                allBinaries.add(String.valueOf(binary));
            }
            return;
        }

        // add 0 to char array
        binary[index] = '0';
        solve(index + 1, n, binary, unique, allBinaries);

        // backtrack and add 1
        binary[index] = '1';
        solve(index + 1, n, binary, unique, allBinaries);
    }


}
