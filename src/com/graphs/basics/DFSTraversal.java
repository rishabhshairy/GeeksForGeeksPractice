package com.graphs.basics;

import java.util.ArrayList;

public class DFSTraversal {
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> dfsList = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        visited[0] = true;

        dfs(0, adj, visited, dfsList);
        return dfsList;
    }

    private void dfs(int currNode, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfsList) {
        visited[currNode] = true;
        dfsList.add(currNode);

        for (Integer adjNode : adj.get(currNode)) {
            if (!visited[adjNode]) {
                visited[adjNode] = true;
                dfs(adjNode,adj,visited,dfsList);
            }
        }
    }
}
