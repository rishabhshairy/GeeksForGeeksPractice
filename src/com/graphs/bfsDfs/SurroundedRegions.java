package com.graphs.bfsDfs;

/**
 * LC 130
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
        new SurroundedRegions().solve(board);
    }

    public void solve(char[][] board) {
        int rowSize = board.length;
        int colSize = board[0].length;

        boolean[][] visited = new boolean[rowSize][colSize];
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        // traverse first row and last row

        for (int i = 0; i < colSize; i++) {
            if (!visited[0][i] && board[0][i] == 'O') {
                dfs(0, i, visited, board, deltaRow, deltaCol);
            }

            if (!visited[rowSize - 1][i] && board[rowSize - 1][i] == 'O') {
                dfs(rowSize - 1, i, visited, board, deltaRow, deltaCol);
            }
        }

        // traverse first col and last col

        for (int i = 0; i < rowSize; i++) {
            if (!visited[i][0] && board[i][0] == 'O') {
                dfs(i, 0, visited, board, deltaRow, deltaCol);
            }

            if (!visited[i][colSize - 1] && board[i][colSize - 1] == 'O') {
                dfs(i, colSize - 1, visited, board, deltaRow, deltaCol);
            }
        }

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col, boolean[][] visited, char[][] board, int[] deltaRow, int[] deltaCol) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') {
            return;
        }
        visited[row][col] = true;
        int rowSize = board.length;
        int colSize = board[0].length;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + deltaRow[i];
            int nextCol = col + deltaCol[i];

            if (nextRow >= 0 && nextRow < rowSize && nextCol >= 0 && nextCol < colSize
                    && !visited[nextRow][nextCol] && board[nextRow][nextCol] == 'O') {
                dfs(nextRow, nextCol, visited, board, deltaRow, deltaCol);

            }
        }

    }
}
