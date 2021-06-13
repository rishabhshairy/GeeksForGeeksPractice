package com.gfg.strings;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequence {
    public static void main(String[] args) {
        String s = "aabc";
        List<String> generated = generate(s);
        for (String sub :
                generated) {
            System.out.println(sub);
        }
    }

    static List<String> generate(String s) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub=s.substring(i,j);
                if (!answer.contains(sub)) {
                    answer.add(sub);
                }

            }
        }
        System.out.println(answer.size());
        return answer;
    }
}
