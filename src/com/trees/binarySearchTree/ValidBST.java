package com.trees.binarySearchTree;

public class ValidBST {
    /**
     * Since for BST, inorder is sorted using that property solve the question
     *
     * @param arr
     * @return
     */
    static boolean isBSTTraversal(int[] arr) {
        // code here
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] >= arr[i]) {
                return false;
            }
        }
        return true;
    }
}
