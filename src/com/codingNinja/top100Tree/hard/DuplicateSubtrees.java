package com.codingNinja.top100Tree.hard;

import com.trees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC652
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 */
public class DuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> pathMap = new HashMap<>();
        solve(root, pathMap, result);
        return result;
    }

    private String solve(TreeNode node, Map<String, Integer> pathMap, List<TreeNode> result) {

        if (node == null) {
            return "";
        }
        String leftPath = solve(node.left, pathMap, result);
        String rightPath = solve(node.right, pathMap, result);

        String path = node.val + "#" + leftPath + "#" + rightPath;
        System.out.println(path);
        if (pathMap.getOrDefault(path, 0) == 1) {
            result.add(node);
        }
        pathMap.put(path, pathMap.getOrDefault(path, 0) + 1);

        return path;
    }
}
