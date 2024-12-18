package com.leetCode.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * LC 2593
 */
public class FindScoreMarkingElements {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 1, 3, 2};
        FindScoreMarkingElements obj = new FindScoreMarkingElements();
        obj.findScore(nums);
    }

    private long findScore(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = nums[i];
            dp[i][1] = i;
        }

        Arrays.sort(dp, (x, y) -> x[0] - y[0]);
        boolean[] visited = new boolean[n];
        long score = 0;

        for (int[] row : dp) {
            int val = row[0];
            int index = row[1];

            if (!visited[index]) {
                score += val;
                visited[index] = true;
                if (index != n - 1) {
                    visited[index + 1] = true;
                }
                if (index != 0) {
                    visited[index - 1] = true;
                }
            }
        }

        return score;
    }


    /**
     * Very High runtime
     *
     * @param nums
     * @return
     */
    public long findScoreUsingMap(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];

        // since tree map will store elements on sorted order
        TreeMap<Integer, List<Integer>> numMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> indexes;
            if (!numMap.containsKey(nums[i])) {
                indexes = new ArrayList<>();
            } else {
                indexes = numMap.get(nums[i]);
            }
            indexes.add(i);
            numMap.put(nums[i], indexes);
        }
        long score = 0;
        for (Integer key : numMap.keySet()) {
            List<Integer> indexes = numMap.get(key);
            for (Integer index : indexes) {
                if (!visited[index]) {
                    score += key;
                    visited[index] = true;
                    if (index != n - 1) {
                        visited[index + 1] = true;
                    }
                    if (index != 0) {
                        visited[index - 1] = true;
                    }
                }
            }
        }
        return score;
    }
}
