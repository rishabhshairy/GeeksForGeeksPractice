package com.graphs.bfsDfs;

import java.util.ArrayList;

public class CycleDetectionDFS {
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int currNode, int parentNode, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {

        visited[currNode] = true;

        for (Integer adjNode :
                adj.get(currNode)) {
            if (!visited[adjNode]) {
                if (dfs(adjNode, currNode, visited, adj)) {
                    return true;
                }
            } else if (parentNode != adjNode) {
                return true;
            }
        }
        return false;
    }
}
