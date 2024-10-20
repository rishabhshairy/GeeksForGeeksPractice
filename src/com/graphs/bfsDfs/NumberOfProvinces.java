package com.graphs.bfsDfs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(new NumberOfProvinces().findCircleNum(matrix));
    }

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjacencyList = generateGraph(isConnected);
        int v = isConnected.length;
        boolean[] visited = new boolean[v + 1];
        int[] count = {0};

        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                count[0]++;
                dfs(i, visited, adjacencyList, count);
            }
        }


        return count[0];
    }

    private void dfs(int currNode, boolean[] visited, List<List<Integer>> adjacencyList, int[] count) {
        visited[currNode] = true;
        for (Integer adjNode : adjacencyList.get(currNode)) {
            if (!visited[adjNode]) {
                visited[adjNode] = true;
                dfs(adjNode, visited, adjacencyList, count);

            }
        }


    }

    private List<List<Integer>> generateGraph(int[][] isConnected) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = isConnected.length;

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && isConnected[j][i] == 1 && i != j) {
                    graph.get(i + 1).add(j + 1);
                }
            }
        }
        return graph;
    }
}
