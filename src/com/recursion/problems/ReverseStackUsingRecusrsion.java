package com.recursion.problems;

import java.util.Stack;

public class ReverseStackUsingRecusrsion {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(2);
        s.push(1);
        reverse(s);
    }
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        if (s.isEmpty()){
            return;
        }
        Integer temp = s.pop();
        reverse(s);
        insertBackToStack(s,temp);
    }

    private static void insertBackToStack(Stack<Integer> s, Integer temp) {
        if (s.isEmpty()){
            s.push(temp);
            return;
        }
        int x = s.pop();
        insertBackToStack(s,temp);
        s.push(x);

    }
}
