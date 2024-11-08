package com.slidingwindow.hard;

public class MinFlipOperationsToAlternateBinaryString {

    public static void main(String[] args) {
        String s = "01001001101";
        new MinFlipOperationsToAlternateBinaryString().minFlips(s);
    }

    public int minFlips(String s) {
        int n = s.length();
        s = s + s;
        int res = s.length();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s0 = new StringBuilder();
        int flipCount1 = 0;
        int flipCount0 = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                s1.append("1");
                s0.append("0");
            } else {
                s1.append("0");
                s0.append("1");
            }
        }

        int left = 0, right = 0;

        while (right < s.length()) {

            if (s1.charAt(right) != s.charAt(right)) {
                flipCount1++;
            }
            if (s0.charAt(right) != s.charAt(right)) {
                flipCount0++;
            }

            // when we breach window decrement the flipCount
            if (right - left + 1 > n) {
                if (s1.charAt(left) != s.charAt(left)) {
                    flipCount1--;
                }
                if (s0.charAt(left) != s.charAt(left)) {
                    flipCount0--;
                }
                left++;
            }

            // update result only when we are at window length
            if (right - left + 1 == n) {
                res = Math.min(res, Math.min(flipCount0, flipCount1));
            }

            right++;
        }
//        System.out.print(res);
        return res;

    }
}
