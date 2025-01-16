package com.stackQueue.learning;

public class ImplementStackUsingArray {
    private int[] arr;
    private int top;

    public ImplementStackUsingArray() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        // Your Code
        top++;
        arr[top] = x;
        return;
    }

    public int pop() {
        // Your Code
        if (top == -1) {
            return -1;
        } else {
            int val = arr[top];
            top--;
            return val;
        }
    }
}
