package com.interviewBit.stackqueue;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(solve(s));
    }

    public static String solve(String s) {
        Queue<Character> streamChar = new ArrayDeque<>();
        Set<Character> characterSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (characterSet.contains(s.charAt(i))) {
                streamChar.remove(s.charAt(i));
            } else {
                characterSet.add(s.charAt(i));
                streamChar.add(s.charAt(i));
            }

            // checking for no non rep char
            if (streamChar.isEmpty()) {
                sb.append('#');
            } else {
                sb.append(streamChar.peek());
            }
        }

        return sb.toString();
    }
}
