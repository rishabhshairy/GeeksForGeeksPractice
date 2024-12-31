package com.trees.medium;

import com.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindMaxEachRow {

    List<Integer> ans;

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (depth == ans.size()) {
            ans.add(node.val);
        } else {
            // this part will be used when we track back to tree
            ans.set(depth, Math.max(ans.get(depth), node.val));
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    /**
     * This is a BFS approach
     *
     * @param root
     * @return
     */
    public List<Integer> largestValuesBFS(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            int maxi = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode currNode = nodeQueue.peek();
                if (currNode.left != null) {
                    nodeQueue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    nodeQueue.offer(currNode.right);
                }
                maxi = Math.max(maxi, currNode.val);
                nodeQueue.poll();
            }
            result.add(maxi);
        }
        return result;
    }
}
