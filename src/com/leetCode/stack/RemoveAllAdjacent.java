package com.leetCode.stack;

import java.util.Stack;

public class RemoveAllAdjacent {
    public static void main(String[] args) {
        String s = "abbaca";
        RemoveAllAdjacent obj = new RemoveAllAdjacent();
        obj.removeDuplicates(s);
    }

    public String removeDuplicates(String s) {
        if (s.length() == 1) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {


            while (!stack.isEmpty() && stack.peek().equals(s.charAt(i))) {
                stack.pop();
            }
            if (stack.peek()!=s.charAt(i)){
                stack.push(s.charAt(i));
            }
            System.out.println(stack);
        }

        return "";
    }
}
