package com.gfg.trees;

import java.util.ArrayList;
import java.util.Collections;

public class BoundryTraversal {
    ArrayList<Integer> printBoundary(Node node) {
        ArrayList<Integer> leftNodes = new ArrayList<>();
        ArrayList<Integer> rightNodes = new ArrayList<>();

        if (node == null) {
            return leftNodes;
        } else {
            leftNodes.add(node.data);
        }

        if (node.left != null) {
            leftNodes.add(node.left.data);
            traverseLeft(node.left, leftNodes);
            leftNodes.remove(leftNodes.size() - 1);
        }
        traverseLeafNodes(node, leftNodes);
        if (node.right != null) {
            rightNodes.add(node.right.data);
            traverseRight(node.right, rightNodes);
            rightNodes.remove(rightNodes.size() - 1);
        }

        Collections.reverse(rightNodes);
        leftNodes.addAll(rightNodes);
        return leftNodes;
    }

    private void traverseLeafNodes(Node node, ArrayList<Integer> leftNodes) {
        if (node.left == null && node.right == null) {
            leftNodes.add(node.data);
        }

        if (node.left != null) {
            traverseLeafNodes(node.left, leftNodes);
        }
        if (node.right != null) {
            traverseLeafNodes(node.right, leftNodes);
        }
    }

    private void traverseRight(Node node, ArrayList<Integer> rightNodes) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }

        if (node.right == null && node.left != null) {
            rightNodes.add(node.left.data);
            traverseRight(node.left, rightNodes);
        } else {
            rightNodes.add(node.right.data);
            traverseRight(node.right, rightNodes);
        }
    }

    private void traverseLeft(Node node, ArrayList<Integer> leftNodes) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }

        if (node.left == null && node.right != null) {
            leftNodes.add(node.right.data);
            traverseLeft(node.right, leftNodes);
        } else {
            leftNodes.add(node.left.data);
            traverseLeft(node.left, leftNodes);
        }

    }
}
