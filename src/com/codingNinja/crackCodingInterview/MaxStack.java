package com.codingNinja.crackCodingInterview;

import java.util.Collections;
import java.util.Stack;

public class MaxStack {

    Stack<Integer> maxStack;
    int maxi = Integer.MIN_VALUE;

    public MaxStack() {
        // Write your code here.
        maxStack = new Stack<>();
    }

    public void specialPush(int value) {
        // Write your code here.
        if (maxStack.isEmpty()) {
            maxi = value;
            maxStack.push(value);
        } else {
            if (value < maxi) {
                maxStack.push(value);
            } else {
                maxStack.push(2 * value - maxi);
                maxi = value;
            }
        }

    }

    // Return the popped value.
    public int specialPop() {
        if (maxStack.isEmpty()) {
            return -1;
        }
        int y = maxStack.peek();
        maxStack.pop();
        if (y > maxi) {
            int curr = maxi;
            maxi = 2 * maxi - y;
            return curr;

        }
        return y;

    }

    // Return the value at the top of stack.
    public int specialTop() {
        // Write your code here.
        if (maxStack.isEmpty()){
            return -1;
        }
        int t = maxStack.peek();
        if (t > maxi){
            return maxi;
        }
        return t;
    }

    // Return the maximum value in stack.
    public int specialMax() {
        // Write your code here.
        if (maxStack.isEmpty()){
            return -1;
        }
        return maxi;
    }
}
