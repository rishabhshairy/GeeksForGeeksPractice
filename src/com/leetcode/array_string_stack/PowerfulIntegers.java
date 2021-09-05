package com.leetcode.array_string_stack;

import java.util.*;

public class PowerfulIntegers {
    public static void main(String[] args) {
        int x = 2, y = 3, bound = 10;
        powerfulIntegers(x, y, bound);
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> powers = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int i = 1;

        while (i < bound) {
            int j = 1;
            while (j < bound) {
                if (i + j < bound) {
                    powers.add(i + j);
                }
                j *= y;
                if (y == 1) {
                    break;
                }
            }
            i *= x;
            if (x == 1) {
                break;
            }
        }

        ans.addAll(powers);
        return ans;
    }
}
