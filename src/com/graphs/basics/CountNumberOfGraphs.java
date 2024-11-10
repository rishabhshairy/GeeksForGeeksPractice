package com.graphs.basics;

/**
 * GFG
 * Given an integer n representing number of vertices.
 * Find out how many undirected graphs (not necessarily connected) can be constructed out of a given n number of vertices.
 */
public class CountNumberOfGraphs {
    static long count(int n) {
        // code here
        return (long) Math.pow(2, n * (n - 1) / 2);

    }
}
