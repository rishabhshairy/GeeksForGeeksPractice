package com.interviewbit.stackqueue;

import java.util.*;

public class SimplifyDirectoryPath {
    public static void main(String[] args) {
        String s = "/...";
        System.out.println(simplifyPath(s));
    }

    public static String simplifyPath(String A) {
        StringBuilder sb = new StringBuilder();
        Deque<String> path = new ArrayDeque<>();

        String[] allPath = A.split("/");

        for (int i = 0; i < allPath.length; i++) {
            if (allPath[i].equals("..")) {
                if (!path.isEmpty()) {
                    path.pop();
                }
            } else if (!allPath[i].equals(".") && !allPath[i].equals("") && !allPath[i].equals("/")) {
                path.push("/" + allPath[i]);
            }
        }

        if (path.isEmpty()) {
            return "/";
        }
        while (!path.isEmpty()) {
            sb.append(path.removeLast());
        }

        return sb.toString();


    }
}
