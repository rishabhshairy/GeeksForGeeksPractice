package com.leetCode.graphs.unionFind;

import java.util.ArrayList;
import java.util.List;


/**
 * LC 684
 */
public class RedundantConnections {

    public static void main(String[] args) {
//        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[][] edges = {{1, 3}, {3, 4}, {1, 5}, {3, 5}, {2, 3}};
        RedundantConnections obj = new RedundantConnections();
        obj.findRedundantConnection(edges);
    }


    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);
        List<List<Integer>> res = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int parentU = ds.findUltimateParent(u);
            int parentV = ds.findUltimateParent(v);

            if (parentU == parentV) {

                List<Integer> redundant = new ArrayList<>();
                redundant.add(u);
                redundant.add(v);
                res.add(redundant);

            } else {
                ds.union(u, v);
                System.out.println(ds.parents);
            }
        }
        System.out.println(res);
        int[] redundantEdges = new int[2];

        if (res.size() > 1) {
            redundantEdges[0] = res.get(res.size() - 1).get(0);
            redundantEdges[1] = res.get(res.size() - 1).get(1);
        } else {
            redundantEdges[0] = res.get(0).get(0);
            redundantEdges[1] = res.get(0).get(1);
        }
        return redundantEdges;
    }

    static class DisjointSet {
        List<Integer> parents = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                parents.add(i);
                size.add(1);
            }
        }

        int findUltimateParent(int node) {
            if (parents.get(node) == node) {
                return node;
            }
            int ultParent = findUltimateParent(parents.get(node));
            parents.set(node, ultParent);
            return parents.get(node);
        }

        void union(int u, int v) {
            int ultParU = findUltimateParent(u);
            int ultParV = findUltimateParent(v);

            if (ultParU == ultParV) {
                return;
            }

            if (size.get(ultParU) < size.get(ultParV)) {
                parents.set(ultParU, ultParV);
                int newSize = size.get(ultParU) + size.get(ultParV);
                size.set(ultParV, newSize);
            } else {
                parents.set(ultParV, ultParU);
                int newSize = size.get(ultParU) + size.get(ultParV);
                size.set(ultParU, newSize);
            }
        }
    }
}
