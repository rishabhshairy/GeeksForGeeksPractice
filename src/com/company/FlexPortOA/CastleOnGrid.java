package com.company.FlexPortOA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CastleOnGrid {
    public static void main(String[] args) {
        List<String> grid = Arrays.asList("...", ".X.", "...");
        int startX = 0;
        int startY = 0;
        int goalX = 1;
        int goalY = 2;

        System.out.println(minimumMoves(grid, startX, startY, goalX, goalY));
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
        // Write your code here
        if (grid == null || grid.size() < 1) {
            return -1;
        }
        int n = grid.size();
        char[][] mat = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = grid.get(i).charAt(j);
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        boolean[][] visited = new boolean[n][n];
        int[][] steps = new int[n][n];
        Queue<Point> nodeQueue = new LinkedList<>();
        nodeQueue.offer(new Point(startX, startY));
        visited[startX][startY] = true;

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        while (!nodeQueue.isEmpty()) {
            Point currPoint = nodeQueue.poll();
            int currRow = currPoint.row;
            int currCol = currPoint.col;

            for (int i = 0; i < 4; i++) {
                int index = 1;
                while (isMoveValid(currRow + deltaRow[i] * index, currCol + deltaCol[i] * index, n)
                        && mat[currRow + deltaRow[i] * index][currCol + deltaCol[i] * index] == '.'
                        && !visited[currRow + deltaRow[i] * index][currCol + deltaCol[i] * index]) {

                    int nextRow = currRow + deltaRow[i] * index;
                    int nextCol = currCol + deltaCol[i] * index;
                    visited[nextRow][nextCol] = true;
                    nodeQueue.add(new Point(nextRow, nextCol));
                    steps[nextRow][nextCol] = steps[currRow][currCol] + 1;

                    if (nextRow == goalX && nextCol == goalY) {
//                        printSteps(steps);
                        return steps[nextRow][nextCol];
                    }
                    index++;
                }
            }

        }
        return -1;
    }

    private static void printSteps(int[][] steps) {
        for (int i = 0; i < steps.length; i++) {
            for (int j = 0; j < steps.length; j++) {
                System.out.print(steps[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isMoveValid(int nextRow, int nextCol, int n) {
        return nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n;
    }
}
