package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationOptimal {
    public static void main(String[] args) {
        int n = 4;
        int k = 17;
        KthPermutationOptimal kthPermutationOptimal = new KthPermutationOptimal();
        System.out.println(kthPermutationOptimal.getPermutation(n, k));
    }

    public String getPermutation(int n, int k) {
        int fact = 1;
        // [1,2,3,4]
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n); // adding last number to array
        StringBuilder result = new StringBuilder();
        k -= 1; // reducing K as we are using 0-based indexing
        while (true) {
            // k/fact --> example because 16/6 --> 2 here is total no of permutation in 1st block
            int numOfPermutation = k / fact;
            result.append(numbers.get(numOfPermutation));
            numbers.remove(numOfPermutation);
            if (numbers.size() == 0) {
                break;
            }
            k = k % fact; // Reducing k by factorial , eg --> 16%6 --> 2
            fact = fact / numbers.size(); // Reducing factorial by new list size eg --> 3
        }
        return result.toString();
    }
}
