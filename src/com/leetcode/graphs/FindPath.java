package com.leetcode.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 1971. Find if Path Exists in Graph
public class FindPath {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int start = 0;
        int end = 5;
        FindPath fp=new FindPath();
        System.out.println(fp.validPath(n,edges,start,end));
    }

    public boolean validPath(int n, int[][] edges, int start, int end) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            final int currNode = queue.poll();
            if (end == currNode) {
                return true;
            }
            final Set<Integer> neighbours = find(edges, n, currNode);
            for (Integer node :
                    neighbours) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
        return false;
    }

    private Set<Integer> find(int[][] edges, int n, int currNode) {
        Set<Integer> neighbourSet = new HashSet<>();
        for (int[] edge :
                edges) {
            if (edge[0] == currNode) {
                neighbourSet.add(edge[1]);
            } else if (edge[1] == currNode) {
                neighbourSet.add(edge[0]);
            }
        }
        return neighbourSet;
    }
}
