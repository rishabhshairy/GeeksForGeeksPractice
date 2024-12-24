package com.graphs.minSpanningTree;

import java.util.ArrayList;
import java.util.List;

public class NoOfProvincesUnionFind {
    /**
     * Find unique ultimate parents using Union-Find
     * Since, every vertex will have one boss parent
     *
     * @param adj
     * @param V
     * @return
     */
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // Create Disjoint Set Data Structure
        DisjointSet ds = new DisjointSet(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1) {
                    ds.union(i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < V; i++) {
            if (ds.parents.get(i) == i) {
                count++;
            }
        }
        return count;
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
            if (node == parents.get(node)) {
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
