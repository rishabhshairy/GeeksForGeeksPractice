package com.codingNinja.crackCodingInterview.easy;

import java.util.Collections;
import java.util.Stack;

public class QueueUsing2Stacks {
    public static void main(String[] args) {

    }

    Stack<Integer> stk1, stk2;

    public QueueUsing2Stacks() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }

    // Enqueues 'X' into the queue. Returns true after enqueuing.
    public boolean enqueue(int x) {
        // Write your code here.
        stk1.push(x);
        stk2.push(x);
        return true;
    }

    /*
       Dequeues top element from queue. Returns -1 if the queue is empty,
       otherwise returns the popped element.
    */
    public int dequeue() {
        // Write your code here.
        if (stk2.isEmpty()) {
            return -1;
        } else {
            Collections.reverse(stk2);
            int popEle = stk2.pop();
            Collections.reverse(stk2);
            return popEle;
        }
    }
}
