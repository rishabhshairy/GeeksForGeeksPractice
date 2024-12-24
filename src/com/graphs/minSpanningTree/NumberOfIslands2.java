package com.graphs.minSpanningTree;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {

    //First Declare Disjoint set data structure

    static class DisjointSet {
        List<Integer> parents = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int v) {
            for (int i = 0; i <= v; i++) {
                parents.add(i);
                size.add(1);
            }
        }

        int findUltimateParent(int node) {
            if (node == parents.get(node)) {
                return node;
            }

            int ultPar = findUltimateParent(parents.get(node));
            parents.set(node, ultPar);
            return parents.get(node);
        }

        void union(int u, int v) {
            int ultParU = findUltimateParent(u);
            int ultParV = findUltimateParent(v);

            if (ultParV == ultParU) {
                return;
            }

            if (ultParU < ultParV) {
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

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        DisjointSet ds = new DisjointSet(rows * cols);
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[rows][cols];

        int count = 0;
        for (int[] op : operators) {
            int currRow = op[0];
            int currCol = op[1];
            // if the cell is already marked
            if (visited[currRow][currCol]) {
                result.add(count);
                continue;
            }

            visited[currRow][currCol] = true;
            count++;

            // declare delta rows and cols
            int[] deltaRow = {-1, 0, 1, 0};
            int[] deltaCol = {0, 1, 0, -1};

            // go through all adjacent
            for (int i = 0; i < 4; i++) {
                int adjRow = currRow + deltaRow[i];
                int adjCol = currCol + deltaCol[i];
                if (isValid(adjRow, adjCol, rows, cols)) {
                    // adjacent should be an island
                    if (visited[adjRow][adjCol]) {
                        // now find node numbers using row and col and union them

                        int currNodeNum = (currRow * cols) + currCol;
                        int adjNodeNum = (adjRow * cols) + adjCol;
                        // check if they have same ultimate parent
                        if (ds.findUltimateParent(currNodeNum) != ds.findUltimateParent(adjNodeNum)) {
                            // reducing count as islands are joined
                            count--;
                            ds.union(currNodeNum, adjNodeNum);
                        }
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    private boolean isValid(int adjRow, int adjCol, int rows, int cols) {
        return adjRow >= 0 && adjRow < rows && adjCol >= 0 && adjCol < cols;
    }
}
