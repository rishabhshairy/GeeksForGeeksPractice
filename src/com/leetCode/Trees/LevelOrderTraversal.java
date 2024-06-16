package com.leetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        traverse(root, answer);
        return answer;
    }

    private void traverse(TreeNode root, List<List<Integer>> answer) {

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int queueSize = nodes.size();
            List<Integer> nodeValList = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode tempNode = nodes.poll();
                nodeValList.add(tempNode.val);

                if (tempNode.left != null) {
                    nodes.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    nodes.add(tempNode.right);
                }
            }
            answer.add(nodeValList);
        }
    }
}
