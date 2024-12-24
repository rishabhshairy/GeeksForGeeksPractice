package com.trees.hard;

import java.util.ArrayList;
import java.util.List;

public class MaxNumberOfKDivisibleComp {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // form Adjacency List
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjacencyList.get(edges[i][0]).add(edges[i][1]);
            adjacencyList.get(edges[i][1]).add(edges[i][0]);
        }

        int[] ans = new int[1];
        dfs(0, -1, ans, adjacencyList, values, k);

        return ans[0];
    }

    private long dfs(int node, int parent, int[] ans, List<List<Integer>> adjacencyList, int[] values, int k) {
        long sum = values[node];

        // iterate through graph for adjacency node and add to sum
        for (Integer adjNode : adjacencyList.get(node)) {
            if (adjNode != parent) {
                sum += dfs(adjNode, node, ans, adjacencyList, values, k);
            }
        }

        if (sum % k == 0) {
            ans[0]++;
        }
        return sum;
    }
}
