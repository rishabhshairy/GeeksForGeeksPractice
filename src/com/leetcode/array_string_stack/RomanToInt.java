package com.leetcode.array_string_stack;

import java.util.HashMap;

public class RomanToInt {
    public static void main(String[] args) {
        String s = "IV";
        System.out.println(convert(s));
    }

    static int convert(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);

        char[] allChars = s.toCharArray();
        int num = 0;
        int prevNum = 0;

        if (s.length() == 1) {
            return charMap.get(s.charAt(0));
        }

        for (int i = allChars.length - 1; i >= 0; i--) {
            Character current = allChars[i];

            int currNum = charMap.get(current);

            num += currNum >= prevNum ? currNum : -currNum;
            prevNum = currNum;
        }

        return num;
    }
}
