package com.graphs.shortestPaths;

import java.util.*;

public class PrintShortestPath {
    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        PrintShortestPath obj = new PrintShortestPath();
        List<Integer> path = obj.shortestPath(n, m, edges);
        System.out.println(path);
    }

    static class Edge {
        int node;
        int distance;

        public Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "node=" + node +
                    ", distance=" + distance +
                    '}';
        }
    }

    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        List<Integer> path = new ArrayList<>();
        List<List<Edge>> adjacencyList = prepareGraph(n, m, edges);


        // initial config
        /*
         * Declare below params
         * Priority Queue
         * Parent arrays to memoize where the parentNode is coming from
         * Distance array to calculate the min distance
         */

        int[] parent = new int[n + 1];
        int[] distance = new int[n + 1];
        // fill parent with current distance
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            distance[i] = (int) 1e9;
        }
        distance[1] = 0;

        PriorityQueue<Edge> nodeQueue = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        nodeQueue.offer(new Edge(1, 0));

        while (!nodeQueue.isEmpty()) {
            Edge currEdge = nodeQueue.poll();
            int currNode = currEdge.node;
            int currDistance = currEdge.distance;

            for (int i = 0; i < adjacencyList.get(currNode).size(); i++) {
                int adjNode = adjacencyList.get(currNode).get(i).node;
                int edgeWeight = adjacencyList.get(currNode).get(i).distance;

                if (edgeWeight + currDistance < distance[adjNode]) {
                    distance[adjNode] = edgeWeight + currDistance;
                    parent[adjNode] = currNode;
                    nodeQueue.offer(new Edge(adjNode, distance[adjNode]));
                }
            }
        }

        if (distance[n] == 1e9) {
            path.add(-1);
            return path;
        }

        int parentNode = n;
        while (parent[parentNode] != parentNode) {
            path.add(parentNode);
            parentNode = parent[parentNode];
        }
        path.add(1);
        // add distance for gfg solution
        path.add(distance[n]);
        Collections.reverse(path);
        return path;
    }

    private List<List<Edge>> prepareGraph(int n, int m, int[][] edges) {
        List<List<Edge>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adjacencyList.get(edges[i][0]).add(new Edge(edges[i][1], edges[i][2]));
            adjacencyList.get(edges[i][1]).add(new Edge(edges[i][0], edges[i][2]));
        }
        return adjacencyList;
    }
}
