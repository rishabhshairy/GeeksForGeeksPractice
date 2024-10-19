package com.codingNinja.top100Tree.medium;

import com.codingNinja.top100Tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedArrToBST {

    public static BinaryTreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
        // Write your code here.
        if (n == 0) {
            return null;
        }
        int mid = n / 2;

        BinaryTreeNode<Integer> root = new BinaryTreeNode(arr.get(mid));
        List<Integer> leftList = arr.subList(0, mid);
        List<Integer> rightList = arr.subList(mid + 1, n);
        root.left = sortedArrToBST(new ArrayList<>(leftList), leftList.size());
        root.right = sortedArrToBST(new ArrayList<>(rightList), rightList.size());
        return root;
    }
}
