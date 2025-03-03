package com.leetCode.arrays;

import java.util.TreeMap;

public class IntToRoman {
    public static void main(String[] args) {
        int num = 58;
//        System.out.println(intToRoman(num));
        System.out.println(intToRomanApproach2(num));
    }

    static String intToRomanApproach2(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    static String intToRoman(int num) {
        TreeMap<Integer, String> charMap = new TreeMap<>();
        charMap.put(1, "I");
        charMap.put(4, "IV");
        charMap.put(5, "V");
        charMap.put(9, "IX");
        charMap.put(10, "X");
        charMap.put(40, "XL");
        charMap.put(50, "L");
        charMap.put(90, "XC");
        charMap.put(100, "C");
        charMap.put(400, "CD");
        charMap.put(500, "D");
        charMap.put(900, "CM");
        charMap.put(1000, "M");

        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            Integer closestKey = charMap.floorKey(num);
            sb.append(charMap.get(closestKey));
            num -= closestKey;
        }

        return sb.toString();
    }
}
