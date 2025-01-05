package com.stackQueue.implementationProblems;

import java.util.Stack;

/**
 * Approach
 * Keep pair of (price,span) inside stack
 */
public class OnlineStockSpan {
    Stack<int[]> stockPrices;

    public OnlineStockSpan() {
        stockPrices = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        //        If The top element of stack price is below or equal to the current price:
        //        Then, the previous element will be span of current.
        while (!stockPrices.isEmpty() && price >= stockPrices.peek()[0]) {
            span += stockPrices.peek()[1];
            stockPrices.pop();
        }
        stockPrices.push(new int[]{price, span});
        return span;
    }
}
