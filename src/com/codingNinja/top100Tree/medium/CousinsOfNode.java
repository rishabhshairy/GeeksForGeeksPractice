package com.codingNinja.top100Tree.medium;

import com.codingNinja.top100Tree.BinaryTreeNode;

import java.util.*;

public class CousinsOfNode {
    public static List<Integer> cousinsOfNode(BinaryTreeNode<Integer> root, int val) {
        // Write you code here
        List<Integer> result = new ArrayList<>();
        Queue<BinaryTreeNode<Integer>> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        BinaryTreeNode<Integer> parentNode = null;

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> currNode = nodeQueue.poll();

                if ((currNode.left != null && currNode.left.data == val) || (currNode.right != null && currNode.right.data == val)) {
                    parentNode = currNode;
                }

                if (currNode != parentNode) {

                    if (currNode.left != null) {
                        nodeQueue.offer(currNode.left);
                    }
                    if (currNode.right != null) {
                        nodeQueue.offer(currNode.right);
                    }
                }

            }
            if (parentNode != null) {
                break;
            }
        }

        // now we found the level, we will put the answer to list
        for (BinaryTreeNode<Integer> node :
                nodeQueue) {
            result.add(node.data);
        }
        Collections.sort(result);
        return result;
    }
}
