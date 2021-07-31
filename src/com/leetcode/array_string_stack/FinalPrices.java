package com.leetcode.array_string_stack;

import java.util.Stack;

public class FinalPrices {
    public static void main(String[] args) {
        int[] prices = {10, 2, 5, 2, 8};
        for (Integer num :
                finalPrices(prices)) {
            System.out.println(num);
        }
    }

    public static int[] finalPrices(int[] prices) {
        Stack<Integer> pricesAfterDiscount = new Stack<>();
        int[] answer = new int[prices.length];

        for (int i = prices.length - 1; i >= 0; i--) {
            if (pricesAfterDiscount.isEmpty()) {
                answer[i] = prices[i];
            } else if (!pricesAfterDiscount.isEmpty() && prices[i] >= pricesAfterDiscount.peek()) {
                answer[i] = prices[i] - pricesAfterDiscount.peek();
            } else if (!pricesAfterDiscount.isEmpty() && prices[i] < pricesAfterDiscount.peek()) {
                while (!pricesAfterDiscount.isEmpty() && prices[i] < pricesAfterDiscount.peek()) {
                    pricesAfterDiscount.pop();
                }

                answer[i] = pricesAfterDiscount.isEmpty() ? prices[i] : prices[i] - pricesAfterDiscount.peek();
            }
            pricesAfterDiscount.push(prices[i]);

        }
        return answer;
    }
}
