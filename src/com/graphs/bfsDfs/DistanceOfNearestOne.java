package com.graphs.bfsDfs;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestOne {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {1, 0, 1}};
        int[][] ans = new DistanceOfNearestOne().nearest(grid);

//        for (int i = 0; i < ans.length; i++) {
//            for (int j = 0; j < ans[0].length; j++) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
    }

    static class Vertex {
        int row;
        int col;
        int step;

        public Vertex(int row, int col, int step) {
            this.row = row;
            this.col = col;
            this.step = step;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "row=" + row +
                    ", col=" + col +
                    ", step=" + step +
                    '}';
        }
    }

    public int[][] nearest(int[][] grid) {
        // Code here

        // first push all One's into queue with step as zero

        int rowSize = grid.length;
        int colSize = grid[0].length;
        int[][] visited = new int[rowSize][colSize];
        int[][] distance = new int[rowSize][colSize]; // using to store distance result
        Queue<Vertex> vertices = new LinkedList<>();

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                // for leetcode solution compare grid[i][j] with Zero
                if (grid[i][j] == 1) {
                    visited[i][j] = 1;
                    vertices.offer(new Vertex(i, j, 0));
                } else {
                    visited[i][j] = 0;
                }
            }
        }

        // declare delta row and col
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        while (!vertices.isEmpty()) {
//            System.out.println(vertices);
            int row = vertices.peek().row;
            int col = vertices.peek().col;
            int currStep = vertices.peek().step;
            // add to distance matrix
            vertices.poll();
            distance[row][col] = currStep;
            System.out.println("distance[row][col]=" + distance[row][col]);
            for (int i = 0; i < 4; i++) {
                int nextRow = row + deltaRow[i];
                int nextCol = col + deltaCol[i];

                if (nextRow >= 0 && nextRow < rowSize && nextCol >= 0 && nextCol < colSize
                        && visited[nextRow][nextCol] == 0) {

                    visited[nextRow][nextCol] = 1;
                    vertices.offer(new Vertex(nextRow, nextCol, currStep + 1));
                }
            }
        }
        return distance;
    }
}
