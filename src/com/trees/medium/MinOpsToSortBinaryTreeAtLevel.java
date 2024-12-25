package com.trees.medium;

import com.trees.TreeNode;

import java.util.*;

public class MinOpsToSortBinaryTreeAtLevel {
    /**
     * Approach
     * Do BFS , find list at each level
     * For each level list find min swaps to sort the array
     *
     * @param root
     * @return
     */
    public int minimumOperations(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int totalMinSwaps = 0;

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = nodeQueue.peek();
                if (curr.left != null) {
                    nodeQueue.offer(curr.left);
                }
                if (curr.right != null) {
                    nodeQueue.offer(curr.right);
                }
                level.add(curr.val);
                nodeQueue.poll();
            }
            int minSwaps = findMinSwapToSort(level);
            totalMinSwaps += minSwaps;
        }
        return totalMinSwaps;
    }

    private int findMinSwapToSort(List<Integer> level) {
        int[] nums = level.stream().mapToInt(i -> i).toArray();
        int minSwaps = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Arrays.sort(nums);

        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || map.get(nums[i]) == i) {
                continue;
            }

            int j = i;
            int cycleSize = 0;
            while (!visited[j]) {
                visited[j] = true;
                j = map.get(nums[j]);
                cycleSize++;
            }

            if (cycleSize > 0) {
                minSwaps += (cycleSize - 1);
            }
        }
        return minSwaps;
    }
}
