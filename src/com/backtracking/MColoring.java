package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
 * <p>
 * Given an undirected graph and an integer M.
 * The task is to determine if the graph can be colored with at most M colors such that no
 * two adjacent vertices of the graph are colored with the same color. Here coloring of a graph means the assignment
 * of colors to all vertices. Print 1 if it is possible to colour vertices and 0 otherwise.
 */
public class MColoring {
    public static void main(String[] args) {


    }

    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int[] colored = new int[n];
        if (isColorable(0, graph, colored, m, n)) {
            return true;
        }
        return false;
    }

    private boolean isColorable(int node, boolean[][] graph, int[] colored, int m, int n) {
        if (node == n) {
            return true;
        }
        for (int i = 1; i <= m; i++) {
            if (isSafe(graph, colored, node, i)) {
                colored[node] = i;
                if (isColorable(node + 1, graph, colored, m, n)){
                    return true;
                }
                colored[node] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(boolean[][] graph, int[] colored, int node, int col) {
        for (int k = 0; k < graph.length; k++) {
            if (k != node && graph[k][node] == true && colored[k] == col) {
                return false;
            }
        }
        return true;
    }
}

