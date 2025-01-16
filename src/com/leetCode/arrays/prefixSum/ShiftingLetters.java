package com.leetCode.arrays.prefixSum;

public class ShiftingLetters {
    public static void main(String[] args) {
        String s = "abc";
        int[] shifts = {3, 5, 9};
        ShiftingLetters obj = new ShiftingLetters();
        obj.shiftingLetters(s, shifts);
        System.out.print(9 % 26);
    }

    /**
     * Optimal Solution
     * Iterate from last and store the sum of shifts
     * first letter will shift --> shifts[0]+...+shifts[n-1]
     * @param s
     * @param shifts
     * @return
     */
    private String shiftingLetters(String s, int[] shifts) {
        int totalShift = 0;
        char[] schar = s.toCharArray();
        for (int i = schar.length - 1; i >= 0; i--) {
            totalShift += (shifts[i] % 26);
            schar[i] = (char) ((schar[i] - 'a' + totalShift) % 26 + 97);
            System.out.println(String.valueOf(schar));
        }
        return String.valueOf(schar);
    }

    /**
     * Brute Force
     *
     * @param s
     * @param shifts
     * @return
     */
    public String shiftingLettersBruteForce(String s, int[] shifts) {
        StringBuilder sb = new StringBuilder();
        char[] schar = s.toCharArray();
        for (int i = 0; i < shifts.length; i++) {
            for (int j = 0; j <= i; j++) {
                char ch = (char) ((schar[j] - 'a' + shifts[i]) % 26 + 97);
                schar[j] = ch;
            }

        }
        return String.valueOf(schar);
    }
}
