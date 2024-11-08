package com.slidingwindow.medium;

public class EqualSubstringWithinBudget {

    public static void main(String[] args) {
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        new EqualSubstringWithinBudget().equalSubstring(s, t, maxCost);
    }

    /**
     * Approach
     * <p>
     * We can boil down this problem to
     * length of max sub array whose sum is less than equal to maxCost
     *
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public int equalSubstring(String s, String t, int maxCost) {
        int[] asciiDiff = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            asciiDiff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int left = 0, right = 0, sum = 0;
        int maxLen = 0;

        while (right < asciiDiff.length) {
            sum += asciiDiff[right];

            while (sum > maxCost) {
                sum -= asciiDiff[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        System.out.println(maxCost);
        return maxLen;
    }
}
