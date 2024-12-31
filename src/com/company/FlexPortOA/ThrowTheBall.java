package com.company.FlexPortOA;

import java.util.ArrayList;
import java.util.List;

public class ThrowTheBall {

    public static void main(String[] args) {
        int[] receiver = {2, 4, 1, 5, 3};
        int seconds = 7;
        ThrowTheBall obj = new ThrowTheBall();
        System.out.println(obj.throwTheBall(receiver, seconds));
    }

    /**
     * Graph based approach
     * Detect Cycle and find cycle length
     * return graph[ seconds % cycleLen ][0]
     *
     * @param receiver
     * @param seconds
     * @return
     */
    int throwTheBall(int[] receiver, int seconds) {
        int n = receiver.length;

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < receiver.length; i++) {
            adjacencyList.get(i + 1).add(receiver[i]);
        }

        // find starting index of graph
        int startingIndex = -1;
        for (int i = 1; i < adjacencyList.size(); i++) {
            if (adjacencyList.get(i).get(0) == 1) {
                startingIndex = i;
            }
        }

        System.out.println(adjacencyList);
        System.out.println("StartIndex =" + startingIndex);

        int[] visited = new int[n + 1];
        int[] dfsVisited = new int[n + 1];
        int[] cycleLen = new int[1];

        for (int i = 1; i < n + 1; i++) {
            if (visited[i] == 0) {
                if (dfsFindCycleLength(startingIndex, adjacencyList, visited, dfsVisited, cycleLen)) {
                    break;
                }
            }
        }

        System.out.println("CycleLen=" + cycleLen[0]);

        return adjacencyList.get(seconds % cycleLen[0]).get(0);
    }

    private boolean dfsFindCycleLength(int startingIndex, List<List<Integer>> adjacencyList, int[] visited, int[] dfsVisited, int[] cycleLen) {
        visited[startingIndex] = 1;
        dfsVisited[startingIndex] = 1;
        cycleLen[0]++;

        for (Integer adjNode : adjacencyList.get(startingIndex)) {
            if (visited[adjNode] == 0) {
                if (dfsFindCycleLength(adjNode, adjacencyList, visited, dfsVisited, cycleLen)) {
                    return true;
                }
            } else if (dfsVisited[adjNode] == 1) {

                return true;
            }
        }
        dfsVisited[startingIndex] = 0;
        return false;
    }

}

