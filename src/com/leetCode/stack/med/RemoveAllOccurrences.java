package com.leetCode.stack.med;

import java.util.Stack;

public class RemoveAllOccurrences {
    public String removeOccurrences(String s, String part) {
        int m = part.length();
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            stack.push(ch);

            if (stack.size() >= m && stack.peek() == part.charAt(m - 1)) {
                StringBuilder temp = new StringBuilder();
                // append top 3 chars
                for (int i = 0; i < m; i++) {
                    temp.append(stack.pop());
                }
                temp.reverse();
                if (!temp.toString().equals(part)) {
                    // push back to stack if temp is not equals
                    for (int i = 0; i < temp.length(); i++) {
                        stack.push(temp.charAt(i));
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
