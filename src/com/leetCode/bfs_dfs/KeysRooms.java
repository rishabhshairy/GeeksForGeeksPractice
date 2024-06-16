package com.leetCode.bfs_dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> keys = new LinkedList<>();

        bfs(visited, rooms, keys);

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private void bfs(boolean[] visited, List<List<Integer>> rooms, Queue<Integer> keys) {
        visited[0] = true;
        for (int key :
                rooms.get(0)) {
            visited[key] = true;
            keys.add(key);
        }

        while (!keys.isEmpty()) {
            int key = keys.poll();
            for (int adjKey :
                    rooms.get(key)) {
                if (!visited[adjKey]) {
                    visited[adjKey] = true;
                    keys.add(adjKey);
                }
            }
        }
    }
}
