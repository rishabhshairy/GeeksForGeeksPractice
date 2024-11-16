package com.graphs.shortestPaths;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LC 1631
 * https://leetcode.com/problems/path-with-minimum-effort/description/
 * <p>
 * You are a hiker preparing for an upcoming hike. You are given heights,
 * a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col).
 * You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell,
 * (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a
 * route that requires the minimum effort.
 * <p>
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 * <p>
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 */
public class PathWithMinEffort {
    public static void main(String[] args) {
        int[][] heights = {{1,10,6,7,9,10,4,9}};
        PathWithMinEffort obj = new PathWithMinEffort();
        System.out.println(obj.minimumEffortPath(heights));
    }

    static class Node {
        int row, col, distanceDiff;

        public Node(int row, int col, int distanceDiff) {
            this.row = row;
            this.col = col;
            this.distanceDiff = distanceDiff;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        int rowCount = heights.length;
        int colCount = heights[0].length;

        // create a distance array
        int[][] distance = new int[rowCount][colCount];
        for (int i = 0; i < distance.length; i++) {
            Arrays.fill(distance[i], (int) 1e9);
        }

        // initial config
        distance[0][0] = 0;

        PriorityQueue<Node> nodeQueue = new PriorityQueue<Node>((x, y) -> x.distanceDiff - y.distanceDiff);
        nodeQueue.offer(new Node(0, 0, 0));

        // since we are allowed only in 4 direction
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        while (!nodeQueue.isEmpty()) {
            Node currNode = nodeQueue.poll();
            int currRow = currNode.row;
            int currCol = currNode.col;
            int currDist = currNode.distanceDiff;

            if (currRow == rowCount - 1 && currCol == colCount - 1) {
                return currDist;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = currRow + deltaRow[i];
                int nextCol = currCol + deltaCol[i];

                if (nextRow >= 0 && nextRow < rowCount && nextCol >= 0 && nextCol < colCount) {
                    int newDiff = Math.max(Math.abs(heights[currRow][currCol] - heights[nextRow][nextCol]), currDist);
                    if (newDiff < distance[nextRow][nextCol]) {
                        distance[nextRow][nextCol] = newDiff;
                        nodeQueue.offer(new Node(nextRow, nextCol, newDiff));
                    }
                }
            }
        }
        return distance[rowCount - 1][colCount - 1];
    }
}
