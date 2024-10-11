package com.trees.traversal;

import com.trees.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair {
    Node node;
    Integer num;

    public Pair(Node node, Integer num) {
        this.node = node;
        this.num = num;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}

public class PrePostInUsingOneStack {
    public static List<List<Integer>> preInPost(Node root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if (root == null) {
            return new ArrayList<>();
        }

        Stack<Pair> pairStack = new Stack<>();
        pairStack.push(new Pair(root, 1));

        while (!pairStack.isEmpty()) {
            Pair curr = pairStack.pop();

            // if num is 1 --> increment it to 2 and add val to preOrder list
            // push the left child
            if (curr.num == 1) {
                pre.add(curr.node.data);
                curr.num++;
                pairStack.push(curr);

                if (curr.getNode().left != null) {
                    pairStack.push(new Pair(curr.getNode().left, 1));
                }
            } else if (curr.getNum() == 2) {

                in.add(curr.getNode().data);
                curr.num++;
                pairStack.push(curr);

                if (curr.getNode().right != null) {
                    pairStack.push(new Pair(curr.getNode().right, 1));
                }
            } else {
                post.add(curr.getNode().data);
            }
        }

        List<List<Integer>> resLists = new ArrayList<>();
        resLists.add(pre);
        resLists.add(in);
        resLists.add(post);
        return resLists;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Getting the pre-order, in-order,
        // and post-order traversals
        List<Integer> pre, in, post;
        List<List<Integer>> traversals = preInPost(root);

        // Extracting the traversals
        // from the result
        pre = traversals.get(0);
        in = traversals.get(1);
        post = traversals.get(2);

        // Printing the traversals
        System.out.print("Preorder traversal: ");
        printList(pre);

        System.out.print("Inorder traversal: ");
        printList(in);

        System.out.print("Postorder traversal: ");
        printList(post);
    }

    public static void printList(List<Integer> list) {
        // Iterate through the list
        // and print each element
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
