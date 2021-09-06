package com.interviewbit.java.ds;

import java.util.Scanner;
import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            int ans = checkParans(s);
            System.out.println(ans);
            t--;
        }
    }

    private static int checkParans(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                characterStack.push(')');
            } else if (characterStack.isEmpty() || characterStack.pop() != s.charAt(i)) {
                return 0;
            }
        }
        return characterStack.isEmpty() ? 1 : 0;
    }
}
