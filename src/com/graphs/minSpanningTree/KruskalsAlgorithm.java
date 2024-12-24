package com.graphs.minSpanningTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalsAlgorithm {

    static class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int v) {
            for (int i = 0; i <= v; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findUltParent(int node) {
            if (parent.get(node) == node) {
                return node;
            }
            int ultParent = findUltParent(parent.get(node));
            parent.set(node, ultParent);
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int ultParentU = findUltParent(u);
            int ultParentV = findUltParent(v);

            if (ultParentU == ultParentV) {
                return;
            }

            if (ultParentU < ultParentV) {
                parent.set(ultParentU, ultParentV);
                int newSizeV = size.get(ultParentU) + size.get(ultParentV);
                size.set(ultParentV, newSizeV);
            } else {
                parent.set(ultParentU, ultParentV);
                int newSizeU = size.get(ultParentU) + size.get(ultParentV);
                size.set(ultParentV, newSizeU);
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j)[0];
                int weight = adj.get(i).get(j)[1];
                int node = i;
                edges.add(new Edge(node, adjNode, weight));
            }
        }

        Collections.sort(edges);
        int mstWt = 0;

        // use disjoint set DS
        DisjointSet ds = new DisjointSet(V);

        // For each Edge, try to find the ultParent of edges
        // if ultU != ultV add that weight to MST weight
        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).src;
            int v = edges.get(i).dest;
            int edgeWeight = edges.get(i).weight;

            if (ds.findUltParent(u) != ds.findUltParent(v)) {
                mstWt += edgeWeight;
                ds.unionBySize(u, v);
            }

        }
        return mstWt;
    }
}
