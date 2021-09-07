package com.leetcode.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 1791. Find Center of Star Graph
public class StarGraph {

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        StarGraph starGraph=new StarGraph();
        System.out.println(starGraph.findCenter(edges));
    }

    public int findCenter(int[][] edges) {
        int n = edges.length - 1;
        boolean[] visited = new boolean[n + 1];
        Set<Integer> neighbour = new HashSet<>();
        Queue<Integer> nodeQueue = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                nodeQueue.add(i);
                visited[i] = true;

                while (!nodeQueue.isEmpty()) {
                    int curr = nodeQueue.poll();

                    for (int[] edge :
                            edges) {
                        for (int k : edge) {
                            if (neighbour.contains(k)) {
                                return k;
                            } else {
                                neighbour.add(k);
                                nodeQueue.add(k);
                            }

                        }
                    }
                }
            }
        }
        return -1;

    }
}
