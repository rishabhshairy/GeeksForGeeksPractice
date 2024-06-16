package com.geeksForGeeks.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllPermutations {
    public static void main(String[] args) {
        String s = "ljr";
        List<String> allPermutations = find_permutation(s);
        for (String perm :
                allPermutations) {
            System.out.println(perm);
        }
    }

    static List<String> find_permutation(String S) {
        // Code here
        List<String> answer = new ArrayList<>();
        permute(S, answer, 0, S.length() - 1);
        Collections.sort(answer);
        return answer;
    }

    private static void permute(String s, List<String> answer, int left, int right) {
        if (left == right) {
            answer.add(s);
        } else {
            for (int i = left; i <= right; i++) {
                s = swap(s, left, i);
                permute(s, answer, left + 1, right);
                s = swap(s, left, i);
            }
        }
    }

    private static String swap(String s, int left, int right) {
        char[] chars = s.toCharArray();
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        return String.valueOf(chars);
    }
}
