package com.company.FlexPortOA;

import java.util.*;

/**
 * Problem: you are given list of flights (BLR-> DLI, GUR->MUM , MUM->CHN, CHN->DLI).
 * you will be given queries and you need to tell whether you can reach from a station to another (GUR->DLI) ?
 */
public class FlightReachability {
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

        System.out.println(canReach(flights, queries));
    }

    private static List<Boolean> canReach(List<String[]> flights, List<String[]> queries) {
        Map<String, List<String>> graph = new HashMap<>();
        List<Boolean> result = new ArrayList<>();
        // building graph
        for (String[] flight : flights) {
            String src = flight[0];
            String destination = flight[1];
            graph.computeIfAbsent(src, k -> new ArrayList<>()).add(destination);
        }

        // using BFS for reachability check
        for (String[] query : queries) {
            String src = query[0];
            String dest = query[1];
            result.add(isReachable(graph, src, dest));
        }
//        System.out.println(result);
        return result;
    }

    private static boolean isReachable(Map<String, List<String>> graph, String source, String destination) {
        if (source.equals(destination)) {
            return true;
        }

        Queue<String> flightQueue = new LinkedList<>();
        Set<String> visitedCities = new HashSet<>();
        flightQueue.offer(source);

        while (!flightQueue.isEmpty()) {
            String currentCity = flightQueue.poll();
            if (visitedCities.contains(currentCity)) {
                continue;
            }

            // mark current city as visited
            visitedCities.add(currentCity);
            for (String adjCity : graph.getOrDefault(currentCity,Collections.emptyList())) {
                if (adjCity.equals(destination)) {
                    return true;
                }
                flightQueue.offer(adjCity);
            }
        }
        return false;
    }
}
