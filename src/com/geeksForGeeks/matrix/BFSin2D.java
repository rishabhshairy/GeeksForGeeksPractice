package com.geeksForGeeks.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class BFSin2D {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};


        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        Queue<String> bfs = new LinkedList<>();
        bfs.add(0 + "," + 0);

        while (!bfs.isEmpty()) {
            String pos = bfs.poll();
            int i = Integer.parseInt(pos.split(",")[0]);
            int j = Integer.parseInt(pos.split(",")[1]);

            if (i < 0 || j < 0 || i >= row || j >= col || visited[i][j]) {
                continue;
            }

            visited[i][j] = true;
            System.out.print(grid[i][j] + " ");
            bfs.add(i + "," + (j - 1));
            bfs.add(i + "," + (j + 1));
            bfs.add((i - 1) + "," + (j));
            bfs.add((i + 1) + "," + (j));
        }
    }
}
