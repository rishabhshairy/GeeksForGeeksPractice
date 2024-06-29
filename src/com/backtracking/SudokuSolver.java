package com.backtracking;

public class SudokuSolver {
    public static void main(String[] args) {

    }

    public void solveSudoku(char[][] board) {
        isSolvable(board);

    }

    private boolean isSolvable(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isCorrectNumber(board, i, j, c)) {
                            board[i][j] = c;
                            if (isSolvable(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }

                        }


                    }
                    return false;
                }

            }
        }
        return true;
    }

    private boolean isCorrectNumber(char[][] board, int row, int col, char c) {

        for (int i = 0; i < 9; i++) {
            // Check for entire row
            if (board[row][i] == c) {
                return false;
            }
            // check entire column
            if (board[i][col] == c) {
                return false;
            }
            // check for sub-matrix of 3x3
            int subRow = (3 * (row / 3) + (i / 3));
            int subCol = (3 * (col / 3) + (i % 3));
            if (board[subRow][subCol] == c) {
                return false;
            }
        }
        return true;
    }

}
