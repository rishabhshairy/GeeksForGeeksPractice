package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueensWithHahsing {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // Fill the board with empty space
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        // Declare hashing
        int[] leftUpperDiagonal = new int[(2 * n) - 1];
        int[] leftLowerDiagonal = new int[(2 * n) - 1];
        int[] leftRow = new int[n];

        placeQueens(0, board, result, leftUpperDiagonal, leftRow, leftLowerDiagonal, n);
        return result;
    }

    private static void placeQueens(int col, char[][] board, List<List<String>> result,
                                    int[] leftUpperDiagonal, int[] leftRow, int[] leftLowerDiagonal, int n) {
        if (col == board.length) {
            result.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftUpperDiagonal[(n - 1) + (col - row)] == 0 && leftRow[row] == 0 && leftLowerDiagonal[row + col] == 0) {
                board[row][col] = 'Q';
                leftUpperDiagonal[(n - 1) + (col - row)] = 1;
                leftRow[row] = 1;
                leftLowerDiagonal[row + col] = 1;
                placeQueens(col + 1, board, result, leftUpperDiagonal, leftRow, leftLowerDiagonal, n);
                board[row][col] = '.';
                leftUpperDiagonal[(n - 1) + (col - row)] = 0;
                leftRow[row] = 0;
                leftLowerDiagonal[row + col] = 0;
            }
        }
    }

    private static List<String> construct(char[][] board) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String answerAtRow = new String(board[i]);
            answer.add(answerAtRow);
        }
        return answer;
    }
}
