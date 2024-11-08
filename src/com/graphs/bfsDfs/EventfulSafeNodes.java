package com.graphs.bfsDfs;

import java.util.ArrayList;
import java.util.List;

public class EventfulSafeNodes {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer> safeNodes = new ArrayList<>();

        /**
         * Approach here is
         * Check cycle in the directed graph
         * any component which is a part of cycle or connected to cycle cannot be safe node
         */
        int n = adj.size();
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        boolean[] isSafeNode = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                checkCycleDFS(i, visited, pathVisited, isSafeNode, adj);
            }
        }
        for (int i = 0; i < isSafeNode.length; i++) {
            if (isSafeNode[i]) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    private boolean checkCycleDFS(int currNode, boolean[] visited, boolean[] pathVisited, boolean[] isSafeNode, List<List<Integer>> adj) {
        visited[currNode] = true;
        pathVisited[currNode] = true;

        for (Integer adjNode : adj.get(currNode)) {
            if (!visited[adjNode]) {
                if (checkCycleDFS(adjNode, visited, pathVisited, isSafeNode, adj)) {
                    return true;
                }
            } else if (pathVisited[adjNode]) {
                return true;
            }
        }
        pathVisited[currNode] = false;
        // marking safe node here as we didn't find any cycle on the path
        isSafeNode[currNode] = true;
        return false;
    }
}
