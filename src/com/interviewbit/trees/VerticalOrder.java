package com.interviewbit.trees;

import java.util.*;

public class VerticalOrder {

    class NodeWithLevel {
        int level;
        TreeNode node;

        public NodeWithLevel(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        Map<Integer, ArrayList<Integer>> nodeMap = new HashMap<>();
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        solve(root, nodeMap);
        int x = Collections.min(nodeMap.keySet());
        while (nodeMap.containsKey(x)) {
            answer.add(nodeMap.get(x));
            x++;
        }
        return answer;
    }

    private void solve(TreeNode root, Map<Integer, ArrayList<Integer>> nodeMap) {
        Queue<NodeWithLevel> levelQueue = new LinkedList<>();
        levelQueue.offer(new NodeWithLevel(0, root));
        while (!levelQueue.isEmpty()) {
            NodeWithLevel temp = levelQueue.poll();
            if (nodeMap.containsKey(temp.level)) {
                nodeMap.get(temp.level).add(temp.node.val);
            } else {
                ArrayList<Integer> nodeList = new ArrayList<>();
                nodeList.add(temp.node.val);
                nodeMap.put(temp.level, nodeList);
            }
            if (temp.node.left != null) {
                levelQueue.offer(new NodeWithLevel(temp.level - 1, temp.node.left));
            }
            if (temp.node.right != null) {
                levelQueue.offer(new NodeWithLevel(temp.level + 1, temp.node.right));
            }
        }

    }
}
