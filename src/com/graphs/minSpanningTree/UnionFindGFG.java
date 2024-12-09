package com.graphs.minSpanningTree;

public class UnionFindGFG {
    int find(int a[], int x) {
        //add code here.
        if (a[x] == x) {
            return x;
        }
        // do path compression
        return find(a, a[x]);
    }

    void unionSet(int a[], int x, int z) {
        //add code here.
        int ultPx = find(a, x);
        int ultPz = find(a, z);
        if (ultPx == ultPz) {
            return;
        }
        a[ultPx] = ultPz;
    }
}
