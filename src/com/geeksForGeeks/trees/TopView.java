package com.geeksForGeeks.trees;

import java.util.*;

public class TopView {
    static class LevelNode {
        int level;
        Node node;

        public LevelNode(int level, Node node) {
            this.level = level;
            this.node = node;
        }
    }

    static ArrayList<Integer> topView(Node root) {
        // add your code
        HashMap<Integer, Integer> nodeMap = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();

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

    private static void solve(Node root, HashMap<Integer, Integer> nodeMap) {
        Queue<LevelNode> levelNodes = new LinkedList<>();
        levelNodes.offer(new LevelNode(0, root));

        while (!levelNodes.isEmpty()) {
            LevelNode temp = levelNodes.poll();
            if (!nodeMap.containsKey(temp.level)) {
                nodeMap.put(temp.level, temp.node.data);
            }

            if (temp.node.left != null) {
                levelNodes.offer(new LevelNode(temp.level - 1, temp.node.left));
            }
            if (temp.node.right != null) {
                levelNodes.offer(new LevelNode(temp.level + 1, temp.node.right));
            }
        }

    }
}
