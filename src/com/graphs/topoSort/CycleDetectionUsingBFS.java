package com.graphs.topoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionUsingBFS {
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] inDegrees = new int[v];

        for (int i = 0; i < v; i++) {
            for (Integer adjNode : adj.get(i)) {
                inDegrees[adjNode]++;
            }
        }

        // Create a Queue and push all vertices with zero nodes into it
        Queue<Integer> nodeQueue = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            if (inDegrees[i] == 0) {
                nodeQueue.offer(i);
            }
        }
        int count = 0;
        while (!nodeQueue.isEmpty()) {
            Integer currNode = nodeQueue.poll();
            count++;
            for (Integer adjNode : adj.get(currNode)) {
                inDegrees[adjNode]--;
                if (inDegrees[adjNode] == 0) {
                    nodeQueue.offer(adjNode);
                }
            }
        }
        return !(count == v);
    }
}
