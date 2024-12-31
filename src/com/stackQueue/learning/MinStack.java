package com.stackQueue.learning;

import java.util.Stack;

public class MinStack {

    Stack<Integer> minStack;
    Stack<Integer> st;

    public MinStack() {
        minStack = new Stack<>();
        st = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        while (minStack.isEmpty() || minStack.peek() > val) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (st.peek().equals(minStack.peek())){
            minStack.pop();
        }
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minStack.pop();
    }
}
