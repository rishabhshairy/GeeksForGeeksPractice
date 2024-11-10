package com.graphs.basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {
    public ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> bfsList = new ArrayList<>();
        int veretex = adj.size();

        boolean[] visited = new boolean[veretex];
        Queue<Integer> nodeQueue = new LinkedList<>();

        visited[0] = true;
        nodeQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            // poll current vertex and add it to answer
            Integer currNode = nodeQueue.poll();
            bfsList.add(currNode);

            // now add all adjacent nodes to queue if they are not visited
            for (Integer adjNode : adj.get(currNode)) {

                if (!visited[adjNode]) {
                    nodeQueue.add(adjNode);
                    visited[adjNode] = true;
                }
            }
        }
        return bfsList;
    }
}
