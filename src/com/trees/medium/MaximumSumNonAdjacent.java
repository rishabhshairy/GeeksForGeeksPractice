package com.trees.medium;

import com.trees.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @implNote Remove map will make it recursive of TC O(2^n)
 */
public class MaximumSumNonAdjacent {
    static Map<Node, Integer> map = new HashMap<>();

    /**
     * Optimal Approach
     * @param root
     * @return
     */
    static int getMaxSumOptimal(Node root) {
        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }

        int include = root.data;
        // if included do not take adjacent
        if (root.left != null) {
            include += getMaxSumOptimal(root.left.left);
            include += getMaxSumOptimal(root.left.right);
        }
        if (root.right != null) {
            include += getMaxSumOptimal(root.right.left);
            include += getMaxSumOptimal(root.right.right);
        }

        int exclude = getMaxSumOptimal(root.left) + getMaxSumOptimal(root.right);
        map.put(root,Math.max(include,exclude));
        return map.get(root);
    }
}
