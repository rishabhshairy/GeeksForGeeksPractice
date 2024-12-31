package com.leetCode.graphs;

import java.util.*;

public class ReConstructItinerary {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("MUC", "LHR"));
        tickets.add(List.of("JFK", "MUC"));
        tickets.add(List.of("SFO", "SJC"));
        tickets.add(List.of("LHR", "SFO"));

        ReConstructItinerary obj = new ReConstructItinerary();
        obj.findItinerary(tickets);
    }

    /**
     * Approach
     * <p>
     * Use eulerian circuit
     *
     * @param tickets
     * @return
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        // Step 1 --> construct graphs
        // no need to compute starting node as it will always be JFK

        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            String start = ticket.get(0);
            String end = ticket.get(1);

            graph.computeIfAbsent(start, k -> new PriorityQueue<>()).add(end);
        }

        String startNode = "JFK";
        List<String> result = new ArrayList<>();
        visit(startNode, graph, result);

        Collections.reverse(result);
//        System.out.println(result);
        return result;
    }

    private void visit(String startNode, Map<String, PriorityQueue<String>> graph, List<String> result) {
        PriorityQueue<String> arrivalCity = graph.get(startNode);

        while (arrivalCity != null && !arrivalCity.isEmpty()) {
            String nextCity = arrivalCity.poll();
            visit(nextCity, graph, result);
        }
        result.add(startNode);
    }
}
