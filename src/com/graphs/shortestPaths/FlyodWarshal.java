package com.graphs.shortestPaths;

/**
 * TC --> O(n^3)
 *
 */
public class FlyodWarshal {
    public void shortestDistance(int[][] mat) {
        // Code here
        int n = mat.length;

        // Step fill matrix with 1e9 or -1

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) {
                    mat[i][j] = (int) 1e9;
                }
                if (i == j) {
                    mat[i][j] = 0;
                }
            }
        }

        // calculate min cost
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][via] != 1e9 && mat[via][j] != 1e9) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                    }

                }
            }
        }

        // just put -1 if there is no path to reach
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1e9) {
                    mat[i][j] = -1;
                }
            }
        }

        // check and update negative cycle
        for (int i = 0; i < n; i++) {
            if (mat[i][i] < 0) {
                // return negative
            }
        }
    }
}
