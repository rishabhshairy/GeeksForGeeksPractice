package com.gfg.trees;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class DiagnonalTraversal {
    public ArrayList<Integer> diagonal(Node root) {
        //add your code here.
        TreeMap<Integer, ArrayList<Integer>> nodeTreeMap = new TreeMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        int depth = 0;
        solve(root, nodeTreeMap, depth);
        for (Map.Entry<Integer, ArrayList<Integer>> entry :
                nodeTreeMap.entrySet()) {
            answer.addAll(entry.getValue());
        }
        return answer;

    }

    private void solve(Node root, TreeMap<Integer, ArrayList<Integer>> nodeTreeMap, int depth) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> nodeList = nodeTreeMap.get(depth);

        if (nodeList == null) {
            nodeList = new ArrayList<>();
            nodeList.add(root.data);
        } else {
            nodeList.add(root.data);
        }

        nodeTreeMap.put(depth, nodeList);
        solve(root.left, nodeTreeMap, depth + 1);
        solve(root.right, nodeTreeMap, depth);
    }
}
