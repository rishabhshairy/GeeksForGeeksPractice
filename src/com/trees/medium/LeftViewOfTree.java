package com.trees.medium;

import com.trees.Node;

import java.util.ArrayList;

public class LeftViewOfTree {
    /**
     * We will code normal pre-order and use level to find each node of left
     *
     * @param root
     * @return
     */
    ArrayList<Integer> leftView(Node root) {
        // code here
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> leftNodes = new ArrayList<>();
        findLeftView(root, 0, leftNodes);
        return leftNodes;
    }

    private void findLeftView(Node root, int level, ArrayList<Integer> leftNodes) {
        if (root == null) {
            return;
        }

        if (level == leftNodes.size()) {
            leftNodes.add(root.data);
        }

        findLeftView(root.left, level + 1, leftNodes);
        findLeftView(root.right, level + 1, leftNodes);
    }
}
