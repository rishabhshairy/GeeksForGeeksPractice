package com.graphs.shortestPaths;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInBinaryMazeGFG {

    public static void main(String[] args) {
        int grid[][] = {{1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}};
        int[] source = {0, 1};
        int[] destination = {2, 2};

        ShortestDistanceInBinaryMazeGFG obj = new ShortestDistanceInBinaryMazeGFG();
        System.out.println(obj.shortestPath(grid, source, destination));
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

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // check if source and destination is same
        if (source[0]==destination[0] && source[1]==destination[1]){
            return 0;
        }

        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[][] distance = new int[rowCount][colCount];

        //declaring distance array to calculate min distance
        for (int i = 0; i < distance.length; i++) {
            Arrays.fill(distance[i], (int) 1e9);
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(new Node(source[0], source[1], 0));
        distance[source[0]][source[1]] = 0;

        // declare delta row and col for iterating in 4 direction
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        // now do BFS traversal
        while (!nodeQueue.isEmpty()) {
            Node currNode = nodeQueue.poll();
            int currRow = currNode.row;
            int currCol = currNode.col;
            int currDistance = currNode.distance;


            for (int i = 0; i < 4; i++) {
                int nextRow = currRow + deltaRow[i];
                int nextCol = currCol + deltaCol[i];

                // check for boundary conditions and min distance
                if (nextRow >= 0 && nextRow < rowCount && nextCol >= 0 && nextCol < colCount
                        && grid[nextRow][nextCol] == 1 && currDistance + 1 < distance[nextRow][nextCol]) {

                    // update new distance
                    distance[nextRow][nextCol] = currDistance + 1;

                    // check if we reached destination
                    if (nextRow == destination[0] && nextCol == destination[1]) {
                        return currDistance + 1;
                    }
                    nodeQueue.offer(new Node(nextRow, nextCol, currDistance + 1));
                }
            }

        }
        return -1;
    }
}
