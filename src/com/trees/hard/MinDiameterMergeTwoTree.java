package com.trees.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LC 3203
 * This problem uses Topo sort or Kahn's Algo
 * It will be using modified Kahn's Algo for undirected graphs
 */
public class MinDiameterMergeTwoTree {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int d1 = findDiameter(edges1);
        int d2 = findDiameter(edges2);

        int combinedDiameter = (int) (Math.ceil(d1 / 2.0) + (int) Math.ceil(d2 / 2.0) + 1);
        return Math.max(Math.max(d1, d2), combinedDiameter);
    }

    private int findDiameter(int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        Queue<Integer> nodeQueue = new LinkedList<>();

        int n = edges.length + 1;
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }


        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
            inDegree[u]++;
            inDegree[v]++;
        }

        // now as per topo sort add nodes to queue whose indegree is 1
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1) {
                nodeQueue.offer(i);
            }
        }

        // count remaining nodes
        int remNodes = n;
        int levelRemoved = 0;

        // now do topo sort
        while (remNodes > 2) {
            int size = nodeQueue.size();
            remNodes -= size;
            levelRemoved++;

            for (int i = 0; i < size; i++) {
                Integer currNode = nodeQueue.poll();
                // go and add adjacent nodes if inDegree is 1
                for (Integer adjNode : adjacencyList.get(currNode)) {
                    inDegree[adjNode]--;
                    if (inDegree[adjNode] == 1) {
                        nodeQueue.offer(adjNode);
                    }
                }
            }
        }

        return remNodes == 2 ? 2 * levelRemoved + 1 : 2 * levelRemoved;
    }
}
