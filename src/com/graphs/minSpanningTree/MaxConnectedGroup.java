package com.graphs.minSpanningTree;

import java.util.*;

/**
 * GFG https://www.geeksforgeeks.org/problems/maximum-connected-group/1
 * You are given a square binary grid. A grid is considered binary if every value in the grid is either 1 or 0.
 * You can change at most one cell in the grid from 0 to 1. You need to find the largest group of connected  1's.
 * Two cells are said to be connected if both are adjacent(top, bottom, left, right) to each other and both have the same value.
 */
public class MaxConnectedGroup {

    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {0, 1}};
        MaxConnectedGroup obj = new MaxConnectedGroup();
        obj.MaxConnection(grid);
    }

    static class DisjointSet {
        List<Integer> parents = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        DisjointSet(int v) {
            for (int i = 0; i <= v; i++) {
                parents.add(i);
                size.add(1);
            }
        }

        int findUltimateParent(int node) {
            if (node == parents.get(node)) {
                return node;
            }
            int ultP = findUltimateParent(parents.get(node));
            parents.set(node, ultP);
            return parents.get(node);
        }

        void union(int u, int v) {
            int ultParU = findUltimateParent(u);
            int ultParV = findUltimateParent(v);

            if (ultParV == ultParU) {
                return;
            }

            if (ultParV > ultParU) {
                parents.set(ultParU, ultParV);
                int newSize = size.get(ultParU) + size.get(ultParV);
                size.set(ultParV, newSize);
            } else {
                parents.set(ultParV, ultParU);
                int newSize = size.get(ultParU) + size.get(ultParV);
                size.set(ultParU, newSize);
            }
        }
    }

    /**
     * TC O(n^2)
     *
     * @param grid
     * @return
     */
    public int MaxConnection(int grid[][]) {
        // Your code here
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);

        // step 1 -- number all the cells
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }

                // else go in all 4 directions
                int[] deltaRow = {-1, 0, 1, 0};
                int[] deltaCol = {0, -1, 0, 1};

                for (int k = 0; k < 4; k++) {
                    int nextRow = row + deltaRow[k];
                    int nextCol = col + deltaCol[k];
                    if (isValid(nextRow, nextCol, n) && grid[nextRow][nextCol] == 1) {
                        // find node number and adjacent node number
                        int node = row * n + col;
                        int adjNode = nextRow * n + nextCol;
                        ds.union(node, adjNode);
                    }
                }
            }
        }

        // step 2 -- try converting 0 to 1
        int maxi = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    continue;
                }

                Set<Integer> components = new HashSet<>();
                int[] deltaRow = {-1, 0, 1, 0};
                int[] deltaCol = {0, -1, 0, 1};

                for (int k = 0; k < 4; k++) {
                    int nextRow = row + deltaRow[k];
                    int nextCol = col + deltaCol[k];
                    // if its valid and grid is 1 then it must be valid component
                    // find the ultimate parent and store in component

                    if (isValid(nextRow, nextCol, n)) {
                        if (grid[nextRow][nextCol] == 1) {
                            int adjNode = nextRow * n + nextCol;
                            components.add(ds.findUltimateParent(adjNode));
                        }
                    }
                }
                int totalSize = 0;
                for (Integer par : components) {
                    totalSize += ds.size.get(par);
                }
                maxi = Math.max(maxi, totalSize + 1);
            }
        }

        // what if all grid is 1 , still we need ultimate parent
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            maxi = Math.max(maxi, ds.size.get(ds.findUltimateParent(cellNo)));
        }

        return maxi;
    }

    private boolean isValid(int nextRow, int nextCol, int n) {
        return nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n;
    }
}
