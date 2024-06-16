package com.geeksForGeeks.trees;

import java.util.HashMap;
import java.util.Map;

public class DuplicateSubTree {
    int dupSub(Node root) {
        // code here
        if (root == null) {
            return 0;
        }
        Map<String, Integer> nodeMap = new HashMap<>();
        solve(root, nodeMap);
        return 0;
    }

    private void solve(Node root, Map<String, Integer> nodeMap) {
        String s="";
    }
}
