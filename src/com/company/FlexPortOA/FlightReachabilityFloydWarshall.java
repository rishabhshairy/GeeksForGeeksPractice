package com.company.FlexPortOA;

import java.util.*;

public class FlightReachabilityFloydWarshall {
    public static void main(String[] args) {
        List<String[]> flights = Arrays.asList(
                new String[]{"BLR", "DLI"},
                new String[]{"GUR", "MUM"},
                new String[]{"MUM", "CHN"},
                new String[]{"CHN", "DLI"}
        );

        List<String[]> queries = Arrays.asList(
                new String[]{"GUR", "DLI"},
                new String[]{"BLR", "CHN"},
                new String[]{"MUM", "DLI"}
        );

        // lets find unique cities
        Set<String> cities = new HashSet<>();
        for (String[] flight : flights) {
            cities.add(flight[0]);
            cities.add(flight[1]);
        }
        System.out.println(cities);

        // now index the cities for adjacency matrix creation
        List<String> cityName = new ArrayList<>(cities);
        Map<String, Integer> cityIndexes = new HashMap<>();

        for (int i = 0; i < cityName.size(); i++) {
            cityIndexes.put(cityName.get(i), i);
        }

        System.out.println(cityIndexes);

        // now construct adjacency matrix
        int n = cityName.size();
        int[][] mat = new int[n][n];

        // initialize matrix
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (i != j) {
                    mat[i][j] = (int) 1e9;
                } else {
                    mat[i][j] = 0;
                }
            }
        }

        // mark destinations as 1
        for (String[] flight : flights) {
            int src = cityIndexes.get(flight[0]);
            int dest = cityIndexes.get(flight[1]);
            mat[src][dest] = 1;
        }

        // flyod warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }

        for (String[] query : queries) {
            int src = cityIndexes.get(query[0]);
            int dest = cityIndexes.get(query[1]);
            System.out.println(mat[src][dest] > 1 && mat[src][dest] != 1e9 ? true : false);
        }
    }
}
