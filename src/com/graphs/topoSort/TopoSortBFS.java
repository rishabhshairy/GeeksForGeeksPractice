package com.graphs.topoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopoSortBFS {

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        // Write your code here
        ArrayList<Integer> nodeStack = new ArrayList<>();
        int[] inDegrees = new int[v];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {

            int X = edges.get(i).get(0);

            int Y = edges.get(i).get(1);

            adj.get(X).add(Y);

        }
        // first find in-degrees of all nodes
        for (int i = 0; i < v; i++) {
            for (Integer adjNode : adj.get(i)) {
                inDegrees[adjNode]++;
            }
        }

        Queue<Integer> nodeQueue = new LinkedList<>();

        // add all nodes with zero in-degrees to queue
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                nodeQueue.add(i);
            }
        }

        // now do normal BFS
        while (!nodeQueue.isEmpty()) {
            Integer currNode = nodeQueue.poll();
            nodeStack.add(currNode);

            // getting neighbour nodes of Curr node and decreasing their in-degree by 1

            for (Integer adjNode : adj.get(currNode)) {
                inDegrees[adjNode]--;
                if (inDegrees[adjNode] == 0) {
                    nodeQueue.add(adjNode);
                }
            }
        }

        return nodeStack;
    }

}
