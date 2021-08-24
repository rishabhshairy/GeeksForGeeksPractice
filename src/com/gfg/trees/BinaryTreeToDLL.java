package com.gfg.trees;

import java.util.ArrayList;

public class BinaryTreeToDLL {
    Node bToDLL(Node root) {
        //  Your code here
        if (root == null) {
            return null;
        }
        ArrayList<Node> answer = new ArrayList<>();
        travelInorder(root, answer);
        Node head = new Node(answer.get(0).data);
        Node temp = head;
        Node preTemp = head;
        for (int i = 1; i < answer.size(); i++) {
            Node newTemp = new Node(answer.get(i).data);
            temp.right = newTemp;
            newTemp.left = preTemp;
            temp = preTemp = newTemp;
        }
        return head;
    }

    private void travelInorder(Node root, ArrayList<Node> answer) {
        if (root == null) {
            return;
        }
        travelInorder(root.left, answer);
        answer.add(root);
        travelInorder(root.right, answer);
    }
}
