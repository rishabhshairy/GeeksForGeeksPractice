package com.recursion.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatInMaze {
    public static void main(String[] args) {
        int n = 4;
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        System.out.println(findPath(maze, n));
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        String path = "";
//        if (m[0][0] == 1) {
//            goToDestination(0, 0, n, m, visited, result, path);
//        }

        // Variables for 2nd approach of comparing cells
        int[] dRow = {1, 0, 0, -1};
        int[] dCol = {0, -1, 1, 0};
        if (m[0][0] == 1) {
            checkIfDestination(0, 0, n, dRow, dCol, m, visited, result, path);
        }

        return result;
    }

    private static void checkIfDestination(int row, int col, int n, int[] dRow, int[] dCol, int[][] m, boolean[][] visited, ArrayList<String> result, String path) {

        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;

        }

        String direction = "DLRU";
        for (int index = 0; index < 4; index++) {
            int nextRow = row + dRow[index];
            int nextCol = col + dCol[index];

            // compare all boundary conditions
            if (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n && !visited[nextRow][nextCol] && m[nextRow][nextCol] == 1) {
                visited[row][col] = true;
                checkIfDestination(nextRow, nextCol, n, dRow, dCol, m, visited, result, path + direction.charAt(index));
                visited[row][col] = false;
            }
        }
    }

    private static void goToDestination(int row, int col, int n, int[][] m, boolean[][] visited, ArrayList<String> result, String path) {
        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }

        // Check downward
        if (row + 1 < n && m[row + 1][col] == 1 && !visited[row + 1][col]) {
            visited[row][col] = true;
            goToDestination(row + 1, col, n, m, visited, result, path + "D");
            visited[row][col] = false;
        }

        // Check Left
        if (col - 1 >= 0 && m[row][col - 1] == 1 && !visited[row][col - 1]) {
            visited[row][col] = true;
            goToDestination(row, col - 1, n, m, visited, result, path + "L");
            visited[row][col] = false;

        }

        // check right
        if (col + 1 < n && m[row][col + 1] == 1 && !visited[row][col + 1]) {
            visited[row][col] = true;
            goToDestination(row, col + 1, n, m, visited, result, path + "R");
            visited[row][col] = false;
        }

        //check upward
        if (row - 1 >= 0 && m[row - 1][col] == 1 && !visited[row - 1][col]) {
            visited[row][col] = true;
            goToDestination(row - 1, col, n, m, visited, result, path + "U");
            visited[row][col] = false;
        }
    }
}
