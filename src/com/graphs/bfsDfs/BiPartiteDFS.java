package com.graphs.bfsDfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BiPartiteDFS {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> rows = new ArrayList<>();
            for (int vertex :
                    graph[i]) {
                rows.add(vertex);
            }
            adjacencyList.add(rows);
        }

        int[] colored = new int[n];
        Arrays.fill(colored, -1);
        int toColor = 0; // 1

        for (int i = 0; i < n; i++) {
            if (colored[i] == -1) {
                if (!dfs(i, toColor, colored, adjacencyList)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int currNode, int toColor, int[] colored, List<List<Integer>> adjacencyList) {
        colored[currNode] = toColor;

        for (Integer adjNode : adjacencyList.get(currNode)) {
            if (colored[adjNode] == -1) {
                if (!dfs(adjNode, 1 - toColor, colored, adjacencyList)) {
                    return false;
                }
            } // if the adjacent is previously colored by traversal and is of same color return false
            else if (colored[adjNode] == toColor) {
                return false;
            }
        }
        return true;
    }
}
