package com.company.FlexPortOA;

import java.util.Stack;

public class InfluentialPairs {
    public static int maxPairProduct(int[] arr) {
        int n = arr.length;

        // Initialize the result as a very small number
        int maxProduct = Integer.MIN_VALUE;

        // Use two pointers: one starting from left, one from right
        int i = 0, j = n - 1;

        // Loop while i < j
        while (i < j) {
            // Calculate the current product
            int product = Math.min(arr[i], arr[j]) * (j - i);

            // Update the maximum product
            maxProduct = Math.max(maxProduct, product);

            // Move the pointer which points to the smaller value
            if (arr[i] < arr[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        int result = maxPairProduct(arr);

        System.out.println("Maximum value is " + result);
    }
}
