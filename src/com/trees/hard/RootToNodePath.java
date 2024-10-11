package com.trees.hard;

import com.trees.TreeNode;

import java.util.ArrayList;

public class RootToNodePath {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        ArrayList<Integer> nodeList = new ArrayList<>();
        if (root == null) {
            return nodeList;
        }
        findPathToNodeX(root, x, nodeList);
        return nodeList;
    }

    private static boolean findPathToNodeX(TreeNode node, int x, ArrayList<Integer> nodeList) {
        if (node == null) {
            return false;
        }
        nodeList.add(node.val);

        if (node.val == x) {
            return true;
        }

        if (findPathToNodeX(node.left, x, nodeList) || findPathToNodeX(node.right, x, nodeList)) {
            return true;
        }
        nodeList.remove(nodeList.size() - 1);
        return false;
    }
}
