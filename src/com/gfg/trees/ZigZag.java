package com.gfg.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZag {
    ArrayList<Integer> zigZagTraversal(Node root) {
        //Add your code here.
        ArrayList<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        ArrayList<ArrayList<Integer>> tempList = new ArrayList<>();
        int depth = 1;
        solve(root, tempList, depth);
        for (ArrayList<Integer> list :
                tempList) {
            answer.addAll(list);
        }
        return answer;
    }

    private void solve(Node root, ArrayList<ArrayList<Integer>> tempList, int depth) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            ArrayList<Integer> tempNodeList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node tempNode = nodeQueue.poll();
                tempNodeList.add(tempNode.data);

                if (tempNode.left != null) {
                    nodeQueue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    nodeQueue.offer(tempNode.right);
                }
            }
            if (depth % 2 == 0) {
                Collections.reverse(tempNodeList);
            }
            tempList.add(tempNodeList);
            depth++;
        }
    }
}
