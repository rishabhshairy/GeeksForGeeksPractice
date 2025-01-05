package com.leetCode.arrays.prefixSum;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LC 2381
 */
public class ShiftingLetters2 {
    public static void main(String[] args) {
        String s = "abc";
        int[][] shifts = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
//        int[][] shifts = {{1, 3, 1}};
//        int[][] shifts = {{0, 0, 0}, {1, 1, 1}};
        ShiftingLetters2 obj = new ShiftingLetters2();
        obj.shiftingLetters(s, shifts);
    }

    /**
     * Brute force will not work as , constrain are too high
     *
     * @param s
     * @param shifts
     * @return
     */
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftDiff = new int[n + 1];
        char[] schars = s.toCharArray();

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            // forward direction
            shiftDiff[start] += (direction == 1 ? 1 : -1);

            // backward
            if (end + 1 < n) {
                shiftDiff[end + 1] -= (direction == 1 ? 1 : -1);
            }
        }
//        for (int num : shiftDiff) {
//            System.out.print(num + " ");
//        }
//        System.out.println();
        int currShift = 0;
        for (int i = 0; i < n; i++) {
            currShift += shiftDiff[i];
            shiftDiff[i] = currShift;
            System.out.print(shiftDiff[i] + " ");
        }

        for (int i = 0; i < schars.length; i++) {
            int totalShift = (shiftDiff[i] % 26) + 26;
            char ch = (char) ((char) ((schars[i] - 'a' + totalShift) % 26) + 'a');
            schars[i] = ch;
        }
        return String.valueOf(schars);
    }
}
