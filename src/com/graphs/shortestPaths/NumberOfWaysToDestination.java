package com.graphs.shortestPaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToDestination {

    static class Path {
        int node;
        long distance;

        public Path(int node, long distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int countPaths(int n, int[][] roads) {
        List<List<Path>> adjacencyList = prepareGraph(roads, n);
        long mod = (int) (1e9 + 7);
        // two arrays needed
        long[] ways = new long[n];
        ways[0] = 1;

        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;

        // declare PQ for Dijkstra
        PriorityQueue<Path> pathQueue = new PriorityQueue<Path>((x, y) -> Long.compare(x.distance, y.distance));
        pathQueue.offer(new Path(0, 0));

        while (!pathQueue.isEmpty()) {
            Path currPath = pathQueue.poll();
            int currNode = currPath.node;
            long currDistance = currPath.distance;

            for (int i = 0; i < adjacencyList.get(currNode).size(); i++) {

                int adjNode = adjacencyList.get(currNode).get(i).node;
                long edgeWeight = adjacencyList.get(currNode).get(i).distance;

                if (edgeWeight + currDistance < distance[adjNode]) {
                    distance[adjNode] = edgeWeight + currDistance;
                    pathQueue.offer(new Path(adjNode, distance[adjNode]));
                    ways[adjNode] = ways[currNode];

                } else if (edgeWeight + currDistance == distance[adjNode]) {
                    // this means we have earlier reached the adjnode from some other path
                    ways[adjNode] = (ways[adjNode] + ways[currNode]) % mod;
                }
            }
        }
        return (int)(ways[n - 1] % mod);
    }

    private List<List<Path>> prepareGraph(int[][] roads, int n) {
        List<List<Path>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // since its a bi-directional graph
        for (int i = 0; i < roads.length; i++) {
            adjacencyList.get(roads[i][0]).add(new Path(roads[i][1], roads[i][2]));
            adjacencyList.get(roads[i][1]).add(new Path(roads[i][0], roads[i][2]));
        }
        return adjacencyList;
    }
}
