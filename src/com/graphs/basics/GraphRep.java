package com.graphs.basics;

import java.util.ArrayList;
import java.util.List;

public class GraphRep {
    public static void main(String[] args) {
        int n = 3;
        int m = 3; // edges
        List<List<Integer>> adj = new ArrayList<>();

        // initialize new list for every node
        // adj list of n+1 nodes , because of 1 based indexing
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // connect 1,2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // connect 1,3
        adj.get(1).add(3);
        adj.get(3).add(1);

        // connect 2,3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // print graph
        for (int i = 1; i < n + 1; i++) {
            System.out.print(i + " --> ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
