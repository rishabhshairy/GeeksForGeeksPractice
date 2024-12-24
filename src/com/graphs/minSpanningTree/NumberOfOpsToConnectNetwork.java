package com.graphs.minSpanningTree;

import java.util.ArrayList;
import java.util.List;

public class NumberOfOpsToConnectNetwork {
    public static void main(String[] args) {
        int n = 4;
        int[][] cables = {{0, 1}, {0, 2}, {1, 2}};
        NumberOfOpsToConnectNetwork obj = new NumberOfOpsToConnectNetwork();
        System.out.println(obj.makeConnected(n, cables));
    }

    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1) {
            return -1;
        }

        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            ds.union(u, v);
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parents.get(i) == i) {
                components++;
            }
        }

        return components - 1;
    }

    static class DisjointSet {
        public List<Integer> parents = new ArrayList<>();
        public List<Integer> size = new ArrayList<>();

        DisjointSet(int v) {
            for (int i = 0; i <= v; i++) {
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

            if (ultParV == ultParU) {
                return;
            }

            if (ultParU < ultParV) {
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
