package com.recursion.patterns;

/**
 * Time complexity 2 power N
 */
public class CountSubsequenceOfSumK {
    public static void main(String[] args) {
        int sum = 7;
        int[] arr = {1, 3, 4, 6, 2, 5};
        int count = countSubsequence(0, arr, 0, sum, arr.length);
        System.out.println(count);
    }

    /**
     * @param i
     * @param arr
     * @param s
     * @param sum
     * @param length
     * @return count of subsequence
     */
    private static int countSubsequence(int i, int[] arr, int s, int sum, int length) {
        if (i == length) {
            if (s == sum) {
                return 1;
            }
            return 0;
        }

        s += arr[i];
        int left = countSubsequence(i + 1, arr, s, sum, length);
        s -= arr[i];
        int right = countSubsequence(i + 1, arr, s, sum, length);
        return left + right;
    }
}
