package com.leetCode.array_string_stack;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int d = 1;
        int m = matrix.length;

        while (top <= bottom - 1 && left <= right - 1) {
            if (d == 1) {
                for (int j = left; j <= right; j++) {
                    answer.add(matrix[top][j]);
                }
                d = 2;
                top++;
            } else if (d == 2) {
                for (int j = top; j <= bottom; j++) {
                    answer.add(matrix[j][right]);
                }
                d = 3;
                right--;
            } else if (d == 3) {
                for (int j = right; j >= left; j--) {
                    answer.add(matrix[bottom][j]);
                }
                d = 4;
                bottom--;
            } else if (d == 4) {
                for (int i = bottom; i >= top; i--) {
                    answer.add(matrix[i][left]);
                }
                d = 1;
                left++;
            }
        }
        return answer;
    }
}
