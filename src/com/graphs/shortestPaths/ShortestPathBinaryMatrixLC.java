package com.graphs.shortestPaths;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrixLC {
    public static void main(String[] args) {
        int[][] grid = {{0}};
        ShortestPathBinaryMatrixLC obj = new ShortestPathBinaryMatrixLC();
        System.out.println(obj.shortestPathBinaryMatrix(grid));
    }

    static class Node {
        int row;
        int col;
        int distance;

        public Node(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        // check if top left is non-zero --> edge case
        if (grid[0][0] != 0) {
            return -1;
        }

        int rowCount = grid.length;
        int colCount = grid[0].length;

        // edge case
        if (rowCount == 1 & colCount == 1) {
            if (grid[0][0] == 0) {
                return 1;
            }
        }

        int[][] distance = new int[rowCount][colCount];

        //declaring distance array to calculate min distance
        for (int i = 0; i < distance.length; i++) {
            Arrays.fill(distance[i], (int) 1e9);
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(new Node(0, 0, 1));
        distance[0][0] = 0;

        // declare delta row and col for iterating in 4 direction
        int[] deltaRow = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] deltaCol = {0, 1, 1, 1, 0, -1, -1, -1};

        // now do BFS traversal
        while (!nodeQueue.isEmpty()) {

            Node currNode = nodeQueue.poll();
            int currRow = currNode.row;
            int currCol = currNode.col;
            int currDistance = currNode.distance;


            for (int i = 0; i < 8; i++) {
                int nextRow = currRow + deltaRow[i];
                int nextCol = currCol + deltaCol[i];

                // check for boundary conditions and min distance
                if (nextRow >= 0 && nextRow < rowCount && nextCol >= 0 && nextCol < colCount
                        && grid[nextRow][nextCol] == 0 && currDistance + 1 < distance[nextRow][nextCol]) {

                    // update new distance
                    distance[nextRow][nextCol] = currDistance + 1;

                    // check if we reached destination
                    if (nextRow == rowCount - 1 && nextCol == colCount - 1) {
                        return currDistance + 1;
                    }
                    nodeQueue.offer(new Node(nextRow, nextCol, currDistance + 1));
                }
            }

        }
        return -1;
    }
}
