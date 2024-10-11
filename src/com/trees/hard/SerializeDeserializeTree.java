package com.trees.hard;

import com.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        StringBuilder tree = new StringBuilder();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();
            if (currNode == null) {
                tree.append("# ");
                continue;
            }
            tree.append(currNode.val + " ");
            nodeQueue.offer(currNode.left);
            nodeQueue.offer(currNode.right);
        }
        return tree.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")){
            return null;
        }

        // creating for traversal
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        // Split the string based on space
        String[] treeNodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(treeNodes[0]));
        nodeQueue.offer(root);

        // traverse using treenode values
        for (int i = 1; i < treeNodes.length; i++) {
            TreeNode parentNode = nodeQueue.poll();
            // form left node
            if (!treeNodes[i].equals("#")){
                parentNode.left = new TreeNode(Integer.parseInt(treeNodes[i]));
                nodeQueue.offer(parentNode.left);
            }
            // form right node
            if (!treeNodes[++i].equals("#")){
                parentNode.right = new TreeNode(Integer.parseInt(treeNodes[i]));
                nodeQueue.offer(parentNode.right);
            }
        }
        return root;
    }
}
