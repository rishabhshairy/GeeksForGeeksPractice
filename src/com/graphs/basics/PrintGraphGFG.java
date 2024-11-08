package com.graphs.basics;

import java.util.ArrayList;
import java.util.List;

public class PrintGraphGFG {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjacencyList.get(edges[i][0]).add(edges[i][1]); // first column node
            adjacencyList.get(edges[i][1]).add(edges[i][0]); // second column node
        }
        return adjacencyList;
    }
}
