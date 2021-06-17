package com.interviewbit;

import java.util.*;

public class FindPermutation {
    public static void main(String[] args) {
        int n = 3;
        String s = "ID";
        for (Integer num :
                findPrem(s, n)) {
            System.out.print(num + " ");
        }
    }

    static ArrayList<Integer> findPrem(final String s, int B) {
        ArrayList<Integer> permList = new ArrayList<>();
        int min = 1;
        int max = B;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                permList.add(min);
                min++;
            } else if (s.charAt(i) == 'D') {
                permList.add(max);
                max--;
            }
        }
        permList.add(min);

        return permList;
    }
}
