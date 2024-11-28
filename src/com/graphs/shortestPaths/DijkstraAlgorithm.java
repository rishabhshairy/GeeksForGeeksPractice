package com.graphs.shortestPaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    public static void main(String[] args) {

    }

    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        int n = adj.size();
        int[] distance = new int[n];
        Arrays.fill(distance, (int) 1e9);
        distance[src] = 0;

        // now create a priority queue
        PriorityQueue<iPair> nodeQueue = new PriorityQueue<iPair>((x, y) -> x.second - y.second);
        nodeQueue.offer(new iPair(src, 0));

        while (!nodeQueue.isEmpty()) {
            iPair currEdge = nodeQueue.poll();
            int currNode = currEdge.first;
            int currDistance = currEdge.second;

            for (int i = 0; i < adj.get(currNode).size(); i++) {
                int adjNode = adj.get(currNode).get(i).first;
                int edgeWeight = adj.get(currNode).get(i).second;

                if (edgeWeight + currDistance < distance[adjNode]) {
                    distance[adjNode] = edgeWeight + currDistance;
                    nodeQueue.offer(new iPair(adjNode, distance[adjNode]));
                }
            }

        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < distance.length; i++) {
            ans.add(distance[i]);
        }
        return ans;
    }

    static class iPair {
        // here first --> node and second --> distance
        int first;
        int second;

        public iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
