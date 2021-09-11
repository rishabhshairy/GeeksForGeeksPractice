package com.learngraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteBFS {
    public static void main(String[] args) {

    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(adj, color, i)) {
                    return false;
                }
            }
        }
        return true;

    }

    private boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int[] color, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 1;

        while (!queue.isEmpty()) {
            Integer currNode = queue.poll();

            for (Integer adjNode :
                    adj.get(currNode)) {
                if (color[adjNode] == -1) {
                    color[adjNode] = color[currNode] ^ 1;
                    queue.add(adjNode);
                } else if (color[adjNode] == color[currNode]) {
                    return false;
                }
            }
        }
        return true;
    }
}
