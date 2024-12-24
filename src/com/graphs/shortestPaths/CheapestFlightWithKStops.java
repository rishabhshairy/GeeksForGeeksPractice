package com.graphs.shortestPaths;

import java.util.*;

public class CheapestFlightWithKStops {

    static class City {
        int node;
        int distance;

        public City(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    static class Flight {
        int src;
        int distance;
        int stop;

        public Flight(int src, int distance, int stop) {
            this.src = src;
            this.distance = distance;
            this.stop = stop;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // adjacency list should contain city info
        List<List<City>> adjacencyList = prepareGraph(n, flights);

        // Create new static class to store flight info
        Queue<Flight> cityQueue = new LinkedList<>();
        cityQueue.offer(new Flight(src, 0, 0));
        int[] distance = new int[n];
        Arrays.fill(distance, (int) 1e9);
        distance[src] = 0;

        while (!cityQueue.isEmpty()) {
            Flight currFlight = cityQueue.poll();

            int currStops = currFlight.stop;
            int currDistance = currFlight.distance;
            int currNode = currFlight.src;

            if (currStops > k) {
                continue;
            }

            for (City adjCity : adjacencyList.get(currNode)) {
                int adjNode = adjCity.node;
                int edgeWeight = adjCity.distance;

                if (edgeWeight + currDistance < distance[adjNode]) {
                    distance[adjNode] = edgeWeight + currDistance;
                    cityQueue.offer(new Flight(adjNode, distance[adjNode], currStops + 1));
                }
            }
        }

        if (distance[dst] == 1e9) {
            return -1;
        }
        return distance[dst];
    }

    private List<List<City>> prepareGraph(int n, int[][] flights) {
        List<List<City>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adjacencyList.get(flights[i][0]).add(new City(flights[i][1], flights[i][2]));
        }
        return adjacencyList;
    }
}
