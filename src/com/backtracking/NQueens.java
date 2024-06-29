package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
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
        placeQueens(0, board, result, n);
        return result;
    }

    private static void placeQueens(int col, char[][] board, List<List<String>> result, int n) {

        // base case --> when we reach end of board
        if (col == n) {
            result.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafeToFill(board, row, col)) {
                board[row][col] = 'Q';
                placeQueens(col + 1, board, result, n);
                board[row][col] = '.';
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

    private static boolean isSafeToFill(char[][] board, int row, int col) {
        // Copying row and column
        int backRow = row;
        int backCol = col;

        // 1st Validation --> Left Upper Diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        row = backRow;
        col = backCol;

        // 2nd validation --> Left Straight
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }
        row = backRow;
        col = backCol;

        while (row < board.length && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }
}
