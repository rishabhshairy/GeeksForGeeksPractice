package com.graphs.minSpanningTree;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetByRank {
    List<Integer> rank = new ArrayList<>(); // for union by rank
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>(); // for union by size

    public DisjointSetByRank(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    // finding ultimate parent
    public int findUltPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        // path compression
        int ulp = findUltPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUltPar(u);
        int ulp_v = findUltPar(v);

        // if same parent -- return
        if (ulp_u == ulp_v) {
            return;
        }

        // else connect smaller to larger
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_u) > rank.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_u, ulp_v); // connect u and v
            rank.set(ulp_u, rank.get(ulp_u) + 1); // increase rank of u
        }
    }



    public static void main(String[] args) {
        DisjointSetByRank ds = new DisjointSetByRank(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 have same parent
        if (ds.findUltPar(3) == ds.findUltPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        // connect 3 and 7
        ds.unionByRank(3, 7);

        if (ds.findUltPar(3) == ds.findUltPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}
