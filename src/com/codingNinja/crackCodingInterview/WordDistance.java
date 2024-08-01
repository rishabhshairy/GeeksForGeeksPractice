package com.codingNinja.crackCodingInterview;

import java.util.*;

public class WordDistance {
    public static void main(String[] args) {
        wordDistance(5, 2, new String[]{"a", "b", "c", "d", "a"}, new String[][]{{"a", "d"}, {"a", "z"}});
    }

    public static int[] wordDistance(int n, int q, String[] arr, String[][] queries) {
        // Write your code here.
        int[] answer = new int[queries.length];
        int index = 0;
        while (index < q) {
            String d1 = queries[index][0];
            String d2 = queries[index][1];
            int t1 = -1;
            int t2 = -1;
            int miniDistance = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equalsIgnoreCase(d1)) {
                    t1 = i;
                }
                if (arr[i].equalsIgnoreCase(d2)) {
                    t2 = i;
                }

                if (t1 != -1 && t2 != -1) {
                    miniDistance = Math.min(miniDistance, Math.abs(t1 - t2));
                } else {
                    miniDistance = n;
                }
            }
            answer[index++] = miniDistance;
        }

        return answer;
    }
}
