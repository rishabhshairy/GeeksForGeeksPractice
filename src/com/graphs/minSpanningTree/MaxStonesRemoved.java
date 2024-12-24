package com.graphs.minSpanningTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * LC 947
 */
public class MaxStonesRemoved {
    static class DisjointSet {
        List<Integer> parents = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int v) {
            for (int i = 0; i <= v; i++) {
                parents.add(i);
                size.add(1);
            }
        }

        int findUltimateParent(int node) {
            if (node == parents.get(node)) {
                return node;
            }

            int ultPar = findUltimateParent(parents.get(node));
            parents.set(node, ultPar);
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

    int maxRemove(int[][] stones, int n) {
        // Code here
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // combine row and col
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.union(nodeRow, nodeCol); // connect row and col
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        // count the no of unique parents
        int count = 0;
        for (Integer key : stoneNodes.keySet()) {
            if (ds.findUltimateParent(key) == key) {
                count++;
            }
        }
        return n - count;
    }
}
