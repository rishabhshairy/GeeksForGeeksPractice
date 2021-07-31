package com.leetcode.array_string_stack;

import java.util.HashMap;

public class FirstUniqueChar {
    public static void main(String[] args) {
        String s = "aabb";
        System.out.print(firstUniqChar(s));
    }

    static int firstUniqChar(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char c :
                s.toCharArray()) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (charMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
