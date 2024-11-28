package com.graphs.shortestPaths;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindCitySmallestNeighbours {
    public static void main(String[] args) {
        int n = 8;
        int[][] edges = {{3,6,5840},{0,6,7765},{0,4,4017},{0,3,3930},{0,7,1730},{3,4,9214},{0,5,5861},{2,6,2600},{1,4,1908},{4,6,665},{1,5,5140},{5,7,6921},{2,7,5674},{1,2,4154},{2,5,913},{0,2,7125},{6,7,6799},{1,7,6166},{4,5,5878},{1,6,4816},{1,3,5591},{5,6,7226},{3,7,3901},{3,5,9989},{2,3,8504},{4,7,2366}};
        int threshold = 919;

        FindCitySmallestNeighbours obj = new FindCitySmallestNeighbours();
        obj.findTheCity(n, edges, threshold);
    }

    /**
     * Application of Floyd Warshall Algorithm
     * Approach
     * --> Create Adjacency Matrix, since given graph is bi-directional
     * --> Compute point to point distance in matrix
     *
     * @param n
     * @param edges
     * @param distanceThreshold
     * @return
     */
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adjacencyMatrix = prepareGraph(n, edges);

        // apply Floyd warshall now
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adjacencyMatrix[i][via] != 1e9 && adjacencyMatrix[via][i] != 1e9) {
                        adjacencyMatrix[i][j] = Math.min(adjacencyMatrix[i][j],
                                adjacencyMatrix[i][via] + adjacencyMatrix[via][j]);
                    }
                }
            }
        }

        // put -1 for non reachable path
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (adjacencyMatrix[i][j] == 1e9) {
//                    adjacencyMatrix[i][j] = -1;
//                }
//            }
//        }

        Map<Integer, Integer> cityMap = new TreeMap<>();

        // considering the self connection as well

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j] <= distanceThreshold) {
                    cityMap.put(i, cityMap.getOrDefault(i, 0) + 1);
                }
            }

        }

        int result = Integer.MAX_VALUE;
        int minCity = Integer.MAX_VALUE;
        for (Integer city : cityMap.keySet()) {

            if (minCity >= cityMap.get(city)) {
                minCity = cityMap.get(city);
                result = city;
            }
        }

        return result;
    }

    private int[][] prepareGraph(int n, int[][] edges) {
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    mat[i][j] = (int) 1e9;
                }
            }
        }

        // insert into graph
        for (int i = 0; i < edges.length; i++) {
            int row = edges[i][0];
            int col = edges[i][1];
            int weight = edges[i][2];

            mat[row][col] = weight;
            mat[col][row] = weight;
        }

        return mat;
    }
}
