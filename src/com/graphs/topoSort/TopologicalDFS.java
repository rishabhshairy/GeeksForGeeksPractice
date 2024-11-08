package com.graphs.topoSort;

import java.util.*;

public class TopologicalDFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here

        boolean[] visited = new boolean[V];
        Deque<Integer> sortedStack = new LinkedList<>();
        int[] answer = new int[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                checkSorting(adj, visited, i, sortedStack);
            }
        }

        int i = 0;
        while (!sortedStack.isEmpty()) {
            answer[i++] = sortedStack.pop();
        }

        return answer;
    }

    private static void checkSorting(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, Deque<Integer> sortedStack) {
        visited[node] = true;
        for (int adjNode :
                adj.get(node)) {
            if (!visited[adjNode]) {
                checkSorting(adj, visited, adjNode, sortedStack);
            }
        }
        sortedStack.push(node);
    }

}
