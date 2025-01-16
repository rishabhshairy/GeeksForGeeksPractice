package com.graphs.bfsDfs;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceToTargetDAG {
    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        AllPathFromSourceToTargetDAG obj = new AllPathFromSourceToTargetDAG();
        obj.allPathsSourceTarget(graph);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;

        List<Integer> sortedStack = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        // add 0 for initial path
        sortedStack.add(0);
        dfs(0, sortedStack, graph, paths);

//        System.out.print(paths);
        return paths;
    }

    private void dfs(int node, List<Integer> sortedStack, int[][] graph, List<List<Integer>> paths) {
        if (node == graph.length - 1) {
            paths.add(new ArrayList<>(sortedStack));
            return;
        }


        for (int ajdNode : graph[node]) {
            sortedStack.add(ajdNode);
            dfs(ajdNode, sortedStack, graph, paths);
            sortedStack.remove(sortedStack.size() - 1);
        }

    }

}
