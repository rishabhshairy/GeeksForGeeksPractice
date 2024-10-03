package com.codingNinja.top100Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AllRootToLeaf {
    public static List<String> allRootToLeaf(BinaryTreeNode<Integer> root) {
        // Write your code here.
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> leafList = new ArrayList<>();
        findPathToLeaf(root, leafList, result);
        return result;
    }

    private static void findPathToLeaf(BinaryTreeNode<Integer> node, ArrayList<Integer> leafList, List<String> result) {
        if (node == null) {
            return;
        }
        leafList.add(node.data);

        if (node.left == null && node.right == null) {
            result.add(leafList.stream().map(String::valueOf).collect(Collectors.joining("")));
        }

        findPathToLeaf(node.left, new ArrayList<>(leafList), result);
        findPathToLeaf(node.right, new ArrayList<>(leafList), result);
        leafList.remove(leafList.size() - 1);
    }
}
