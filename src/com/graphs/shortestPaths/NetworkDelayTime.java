package com.graphs.shortestPaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        NetworkDelayTime obj = new NetworkDelayTime();
        obj.networkDelayTime(times, 4, 2);
    }

    static class NetworkNode {
        int node;
        int time;

        public NetworkNode(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public String toString() {
            return "NetworkNode{" +
                    "node=" + node +
                    ", time=" + time +
                    '}';
        }
    }

    /**
     * We will use Dijkstra Algo to solve this problem
     * max distance from source node will be the result
     *
     * @param times
     * @param n
     * @param k
     * @return
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<NetworkNode>> adjacencyList = prepareGraph(times, n);

        // declare a distance array
        int[] timeToReach = new int[n + 1];
        Arrays.fill(timeToReach, (int) 1e9);
        timeToReach[k] = 0;

        PriorityQueue<NetworkNode> networkQueue = new PriorityQueue<NetworkNode>((x, y) -> x.time - y.time);
        networkQueue.offer(new NetworkNode(k, 0));

        while (!networkQueue.isEmpty()) {
            NetworkNode curr = networkQueue.poll();
            int currNode = curr.node;
            int currTime = curr.time;

            for (int i = 0; i < adjacencyList.get(currNode).size(); i++) {
                NetworkNode adjNetwork = adjacencyList.get(currNode).get(i);
                int edgeWeightTime = adjNetwork.time;
                int adjNode = adjNetwork.node;

                if (currTime + edgeWeightTime < timeToReach[adjNode]) {
                    timeToReach[adjNode] = currTime + edgeWeightTime;
                    networkQueue.offer(new NetworkNode(adjNode, timeToReach[adjNode]));
                }
            }
        }

        // now check for max val in timeToReach arr
        int maxi = -1;

        for (int i = 1; i < timeToReach.length; i++) {
            System.out.println(timeToReach[i]);
            if (timeToReach[i] == 1e9) {
                return -1;
            }
            maxi = Math.max(maxi, timeToReach[i]);

        }
        return maxi;
    }

    private List<List<NetworkNode>> prepareGraph(int[][] times, int n) {
        List<List<NetworkNode>> adjacencyList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            adjacencyList.get(times[i][0]).add(new NetworkNode(times[i][1], times[i][2]));
        }
        System.out.println(adjacencyList);
        return adjacencyList;
    }
}
