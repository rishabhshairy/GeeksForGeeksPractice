package com.leetCode.stack;

import java.util.Stack;

public class FinalPrices {
    public static void main(String[] args) {
        int[] prices = {8, 4, 6, 2, 3};
        for (Integer num :
                finalPrices(prices)) {
            System.out.println(num);
        }
    }

    /**
     * More easy approach with stack
     * Maintain smaller indexes in stack which can be applied as discount
     *
     * @param prices
     * @return
     */
    private static int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int[] results = prices.clone();

        for (int i = 0; i < prices.length; i++) {
            // Process items that can be discounted by current price
            while (!st.isEmpty() && prices[st.peek()] >= prices[i]) {
                results[st.pop()] -= prices[i];
            }
            st.push(i);
        }
        return results;
    }


    public static int[] finalPricesApproach1(int[] prices) {
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
