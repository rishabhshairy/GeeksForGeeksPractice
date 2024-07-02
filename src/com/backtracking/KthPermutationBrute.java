package com.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthPermutationBrute {
    public static void main(String[] args) {
        int n = 4, k = 17;
        String kthPerm = getPermutation(n, k);
        System.out.println(kthPerm);
    }

    private static String getPermutation(int n, int k) {
        String numbers = "";
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers += i;
        }
        findKthPerm(0, numbers.toCharArray(), result);
        Collections.sort(result);
        return result.get(k - 1);
    }

    private static void findKthPerm(int index, char[] numbers, List<String> result) {
        if (index == numbers.length) {
            result.add(new String(numbers));
            return;
        }

        for (int i = index; i < numbers.length; i++) {
            swapNumbers(numbers, i, index);
            findKthPerm(index + 1, numbers, result);
            swapNumbers(numbers, i, index);

        }
    }

    private static void swapNumbers(char[] numbers, int i, int index) {
        char temp = numbers[i];
        numbers[i] = numbers[index];
        numbers[index] = temp;
    }

}
