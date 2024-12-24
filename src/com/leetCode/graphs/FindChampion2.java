package com.leetCode.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 2924
 */
public class FindChampion2 {

    public static void main(String[] args) {
        int[][] edges = {{0, 2}, {1, 3}, {1, 2}};
        FindChampion2 obj = new FindChampion2();
        obj.findChampion(4, edges);
    }

    public int findChampion(int n, int[][] edges) {
        List<List<Integer>> ajacencyList = prepareGraph(n, edges);

        int[] inDegrees = new int[n];

        for (int i = 0; i < n; i++) {
            for (Integer adjNode : ajacencyList.get(i)) {
                inDegrees[adjNode]++;
            }
        }
        int winner = -1;
        int zeros = 0;
        for (int i = 0; i < inDegrees.length; i++) {

            if (inDegrees[i] == 0) {
                zeros++;
                winner = i;
            }
            if (zeros > 1) {
                return -1;
            }
        }
        return winner;
    }

    private List<List<Integer>> prepareGraph(int n, int[][] edges) {
        List<List<Integer>> ajacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ajacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            ajacencyList.get(edges[i][0]).add(edges[i][1]);
        }
        return ajacencyList;
    }
}
