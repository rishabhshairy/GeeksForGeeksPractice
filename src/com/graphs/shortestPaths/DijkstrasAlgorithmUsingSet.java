package com.graphs.shortestPaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class DijkstrasAlgorithmUsingSet {
    static class iPair {
        // here first --> node and second --> distance
        int first;
        int second;

        public iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    ArrayList<Integer> dijkstra(ArrayList<ArrayList<DijkstraAlgorithm.iPair>> adj, int src) {
        int n = adj.size();
        int[] distance = new int[n];
        Arrays.fill(distance, (int) 1e9);
        distance[src] = 0;

        TreeSet<iPair> nodeSet = new TreeSet<iPair>((node1, node2) -> {
            if (node1.first != node2.first && node1.second == node2.second) {
                return 1;
            }
            return node1.second - node2.second;
        });

        nodeSet.add(new iPair(src, 0));

        while (!nodeSet.isEmpty()) {
            iPair curr = nodeSet.pollFirst();
            int currNode = curr.first;
            int currDistance = curr.second;

            for (int i = 0; i < adj.get(currNode).size(); i++) {
                int adjNode = adj.get(currNode).get(i).first;
                int edgeWeight = adj.get(currNode).get(i).second;

                if (edgeWeight + currDistance < distance[adjNode]) {
                    distance[adjNode] = edgeWeight + currDistance;
                    nodeSet.add(new iPair(adjNode, distance[adjNode]));
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < distance.length; i++) {
            ans.add(distance[i]);
        }
        return ans;
    }
}
