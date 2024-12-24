package com.graphs.minSpanningTree;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetBySize {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>(); // for union by size

    public DisjointSetBySize(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }


    public static void main(String[] args) {
        DisjointSetBySize ds = new DisjointSetBySize(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // if 3 and 7 have same parent
        if (ds.findUltPar(3) == ds.findUltPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        // connect 3 and 7
        ds.unionBySize(3, 7);

        if (ds.findUltPar(3) == ds.findUltPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUltPar(u);
        int ulp_v = findUltPar(v);

        // if same parent -- return
        if (ulp_u == ulp_v) {
            return;
        }

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            int newSizeOfV = size.get(ulp_v) + size.get(ulp_u);
            size.set(ulp_v, newSizeOfV);
        } else {
            parent.set(ulp_v, ulp_u);
            int newSizeOfU = size.get(ulp_v) + size.get(ulp_u);
            size.set(ulp_u, newSizeOfU);
        }
    }

    public int findUltPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        // path compression
        int ulp = findUltPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
}
