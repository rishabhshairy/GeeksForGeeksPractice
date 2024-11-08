package com.graphs.shortestPaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathDAGWt {
    public static void main(String[] args) {
        int v = 6, e = 7;
        int[][] edge = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};
        ShortestPathDAGWt obj = new ShortestPathDAGWt();
        obj.shortestPath(v, e, edge);
    }

    static class Edge {
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public int[] shortestPath(int v, int e, int[][] edges) {
        // Step1 --> prepare adjacency list using edges and weight
        List<List<Edge>> adjacencyList = prepareDAG(v, edges);

        // step2 --> Do Topo Sort using DFS
        boolean[] visited = new boolean[v];
        Stack<Integer> nodeStack = new Stack<>();

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfsTopo(i, visited, adjacencyList, nodeStack);
            }
        }

        // Step 3 --> use the sorted array obtained and do BFS kind of traversal to find the shortest distance
        int[] distance = new int[v];
        Arrays.fill(distance, (int) 1e9);
        distance[0] = 0;
        while (!nodeStack.isEmpty()) {
            int currNode = nodeStack.pop();

            // now for all adjacent nodes of current node --> go and update distance
            for (int i = 0; i < adjacencyList.get(currNode).size(); i++) {
                Edge currEdge = adjacencyList.get(currNode).get(i);
                int end = currEdge.end;
                int wt = currEdge.weight;

                if (distance[currNode] + wt < distance[end]) {
                    distance[end] = wt + distance[currNode];
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == 1e9) {
                distance[i] = -1;
            }
            System.out.print(distance[i]+" ");
        }
        return distance;
    }

    private void dfsTopo(int currNode, boolean[] visited, List<List<Edge>> adjacencyList, Stack<Integer> nodeStack) {
        visited[currNode] = true;
        for (int i = 0; i < adjacencyList.get(currNode).size(); i++) {
            int end = adjacencyList.get(currNode).get(i).end;
            if (!visited[end]) {
                dfsTopo(end, visited, adjacencyList, nodeStack);
            }
        }
        nodeStack.push(currNode);
    }

    private List<List<Edge>> prepareDAG(int v, int[][] edges) {
        List<List<Edge>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // remember need to go till EDGES length
        for (int i = 0; i < edges.length; i++) {
            adjacencyList.get(edges[i][0]).add(new Edge(edges[i][1], edges[i][2]));
        }
        return adjacencyList;
    }
}
