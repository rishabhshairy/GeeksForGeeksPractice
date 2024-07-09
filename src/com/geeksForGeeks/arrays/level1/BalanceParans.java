package com.geeksForGeeks.arrays.level1;

import java.util.Scanner;
import java.util.Stack;

public class BalanceParans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(isValid(sc.next()));
    }

    static boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        if (s.length()==1){
            return false;
        }
        for (char c :
                s.toCharArray()) {
            if (c == '(') {
                brackets.push(')');
            } else if (c == '{') {
                brackets.push('}');
            } else if (c == '[') {
                brackets.push(']');
            } else {
                if ( !brackets.isEmpty() && c == brackets.peek() ) {
                    brackets.pop();
                } else {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }
}
