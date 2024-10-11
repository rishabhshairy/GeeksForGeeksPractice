package com.trees.hard;

import com.geeksForGeeks.trees.Node;

import java.util.ArrayList;

public class RootToLeaf {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> leafList = new ArrayList<>();
        findPathToLeaf(root, leafList, result);
        return result;
    }

    private static void findPathToLeaf(Node node, ArrayList<Integer> leafList, ArrayList<ArrayList<Integer>> result) {
        if (node == null) {
            return;
        }
        leafList.add(node.data);

        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(leafList));
        }

        findPathToLeaf(node.left, new ArrayList<>(leafList), result);
        findPathToLeaf(node.right, new ArrayList<>(leafList), result);
        leafList.remove(leafList.size() - 1);
    }
}
