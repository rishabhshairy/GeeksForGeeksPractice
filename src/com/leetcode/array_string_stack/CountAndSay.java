package com.leetcode.array_string_stack;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String s = "11";
        for (int i = 3; i <= n; i++) {
            s = s + "&";
            StringBuilder temp = new StringBuilder();
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j - 1) == s.charAt(j)) {
                    count++;
                } else {
                    temp.append(count);
                    temp.append(s.charAt(j - 1));
                    count = 1;
                }
            }
            s = temp.toString();
        }
        return s;
    }
}
