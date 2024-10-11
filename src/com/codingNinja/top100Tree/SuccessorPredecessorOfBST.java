package com.codingNinja.top100Tree;

import java.util.ArrayList;

public class SuccessorPredecessorOfBST {

    /**
     * Brute force
     * Code 360
     *
     * @param root
     * @param key
     * @return
     */
    public static ArrayList<Integer> findPreSucBruteForce(BinaryTreeNode<Integer> root, int key) {
        // Write your code here.
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> inorderList = new ArrayList<>();

        solve(root, inorderList);
        for (int i = 0; i < inorderList.size(); i++) {
            if (inorderList.get(i) == key) {
                if (i == 0) {
                    result.add(-1);
                } else {
                    result.add(inorderList.get(i - 1));
                }

                if (i == inorderList.size() - 1) {
                    result.add(-1);
                } else {
                    result.add(inorderList.get(i + 1));
                }

            }
        }
        return result;
    }

    private static void solve(BinaryTreeNode<Integer> node, ArrayList<Integer> inorderList) {
        if (node == null) {
            return;
        }
        solve(node.left, inorderList);
        inorderList.add(node.data);
        solve(node.right, inorderList);
    }
}
