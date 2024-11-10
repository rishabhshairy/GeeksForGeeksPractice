package com.graphs.basics;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {
    public static void main(String[] args) {
//        int[][] edges = {{0, 1}, {6, 1}, {2, 4}, {2, 3}, {3, 4}};
        int[][] edges = {{0, 1},{2, 1},{3, 4}};
        int v = 5;
        ArrayList<ArrayList<Integer>> connectedcomponents = connectedcomponents(v, edges);
        System.out.println(connectedcomponents);
    }

    public static ArrayList<ArrayList<Integer>> connectedcomponents(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // storing data in adjacency list
        List<List<Integer>> adjacencyList = generateGraph(v, edges);


        boolean[] visited = new boolean[v];

        for (int node = 0; node < v; node++) {
            ArrayList<Integer> connectedList = new ArrayList<>();
            if (!visited[node]) {
                dfs(node, visited, adjacencyList,connectedList);
//                System.out.println(connectedList);
                result.add(connectedList);
            }
        }


        return result;
    }

    private static void dfs(int node, boolean[] visited, List<List<Integer>> adjacencyList, List<Integer> connectedList) {
        visited[node] = true;
        connectedList.add(node);
        for (Integer adjNode : adjacencyList.get(node)) {
            if (!visited[adjNode]) {
                dfs(adjNode, visited, adjacencyList, connectedList);
            }
        }
    }

    private static List<List<Integer>> generateGraph(int v, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjacencyList.get(edges[i][0]).add(edges[i][1]); // first column node
            adjacencyList.get(edges[i][1]).add(edges[i][0]); // second column node
        }
//        System.out.println(adjacencyList);
        return adjacencyList;
    }
}
