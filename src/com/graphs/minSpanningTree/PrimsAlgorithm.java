package com.graphs.minSpanningTree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    /**
     * TC --> E log E
     * @param v
     * @param e
     * @param adj
     * @return
     */
    static int spanningTree(int v, int e, List<List<int[]>> adj) {
        // Code Here.

        // initial configuration
        // PQ, Visited array, MST List for storing edges

        int[] visited = new int[v];
//        List<int[]> mstEdges = new ArrayList<>();
        PriorityQueue<Node> nodeQueue = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        nodeQueue.offer(new Node(0, 0));
        int sum = 0;

        while (!nodeQueue.isEmpty()) {
            Node curr = nodeQueue.poll();

            int currWeight = curr.weight;
            int currNode = curr.node;

            if (visited[currNode]==1){
                continue;
            }

            visited[currNode] = 1;
            sum += currWeight;

            for (int i = 0; i < adj.get(currNode).size(); i++) {
                int edgeWeight = adj.get(currNode).get(i)[1];
                int adjNode = adj.get(currNode).get(i)[0];

                if (visited[adjNode] == 0) {
                    nodeQueue.add(new Node(adjNode, edgeWeight));
                }
            }
        }
        return sum;
    }

    static class Node {
        int node;
        int weight;

        public Node(int end, int weight) {
            this.node = end;
            this.weight = weight;
        }
    }
}
