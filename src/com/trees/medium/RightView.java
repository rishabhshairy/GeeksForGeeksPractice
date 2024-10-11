package com.trees.medium;

import com.codingNinja.top100Tree.BinaryTreeNode;

import java.util.ArrayList;

public class RightView {
    public static ArrayList<Integer> printRightView(BinaryTreeNode<Integer> root) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();
        findRightView(root, 0, result);
        return result;
    }

    /**
     * Remember - We are using reverse pre-order here to find nodes
     *
     * @param node
     * @param level
     * @param result
     */
    private static void findRightView(BinaryTreeNode<Integer> node, int level, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }

        if (level == result.size()) {
            result.add(node.data);
        }

        findRightView(node.right, level + 1, result);
        findRightView(node.left, level + 1, result);

        // for left view just do normal pre-order
    }
}
