package com.leetcode.array_string_stack;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> answer = generate(n);
        for (List<Integer> ans :
                answer) {
            System.out.print(ans + " ");
        }
    }

    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> numList = new ArrayList<>();
            List<Integer> prevList = null;
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    numList.add(1);
                } else {
                    prevList = triangle.get(i - 1);
                    numList.add(prevList.get(j - 1) + prevList.get(j));
                }
            }
            triangle.add(numList);
        }
        return triangle;
    }
}
