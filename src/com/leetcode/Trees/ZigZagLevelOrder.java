package com.leetcode.Trees;

import java.util.*;

public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        int count = 1;
        solve(root, answer, count);
        return answer;
    }

    private void solve(TreeNode root, List<List<Integer>> answer, int count) {
        Queue<TreeNode> node = new LinkedList<>();
        node.offer(root);
        while (!node.isEmpty()) {
            int queueSize = node.size();
            List<Integer> nodeValList = new ArrayList<>();
            System.out.println(count);
            for (int i = 0; i < queueSize; i++) {
                TreeNode tempNode = node.poll();
                nodeValList.add(tempNode.val);

                if (tempNode.left != null) {
                    node.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    node.add(tempNode.right);
                }
            }
            if (count % 2 != 0) {
                Collections.reverse(nodeValList);
            }
            count++;
            answer.add(nodeValList);
        }
    }
}
