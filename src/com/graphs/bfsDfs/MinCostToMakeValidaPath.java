package com.graphs.bfsDfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinCostToMakeValidaPath {
    static class Node {
        int row;
        int col;
        int weight;

        public Node(int row, int col, int weight) {
            this.row = row;
            this.col = col;
            this.weight = weight;
        }
    }

    public int minCost(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;

        int[][] minCost = new int[rowCount][colCount];
        for (int i = 0; i < minCost.length; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }


        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(new Node(0, 0, 0));
        minCost[0][0] = 0;

        int[] deltaRow = {0, 0, 1, -1};
        int[] deltaCol = {1, -1, 0, 0};

        while (!nodeQueue.isEmpty()) {
            Node currNode = nodeQueue.poll();
            int currRow = currNode.row;
            int currCol = currNode.col;
            int currWeight = currNode.weight;

            for (int direction = 0; direction < 4; direction++) {
                int nextRow = currRow + deltaRow[direction];
                int nextCol = currCol + deltaCol[direction];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < rowCount && nextCol < colCount) {
                    // taking direction + 1 , because each direction represent a value in grid
                    int nextWeight = grid[currRow][currCol] == direction + 1 ? currWeight : currWeight + 1;

                    if (nextWeight < minCost[nextRow][nextCol]) {
                        minCost[nextRow][nextCol] = nextWeight;
                        nodeQueue.offer(new Node(nextRow, nextCol, nextWeight));
                    }
                }
            }
        }
        return minCost[rowCount - 1][colCount - 1];
    }

}
