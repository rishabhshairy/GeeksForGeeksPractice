package com.leetcode.array_string_stack;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    private int row;
    private int col;

    public int orangesRotting(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] direction = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int level = 0;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rottenCord = queue.poll();
                for (int[] dir :
                        direction) {
                    int nx = rottenCord[0] + dir[0];
                    int ny = rottenCord[1] + dir[1];

                    if (nx < 0 || ny < 0 || nx >= row || ny >= col || grid[ny][ny] != 1) {
                        continue;
                    }

                    grid[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        for (int[] rowx : grid) {
            for (int elem :
                    rowx) {
                if (elem == 1) {
                    return -1;
                }
            }
        }
        return level == 0 ? 0 : level - 1;
    }
}
