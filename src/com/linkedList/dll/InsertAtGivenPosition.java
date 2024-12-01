package com.linkedList.dll;

public class InsertAtGivenPosition {
    Node addNode(Node head, int p, int x) {
        // Your code here
        if (head == null) {
            return new Node(x);
        }
        Node temp = head;
//        if (p == 0) {
//            Node xNode = new Node(x);
//            xNode.next = temp.next;
//            xNode.prev = temp;
//            temp.next = xNode;
//            return head;
//        }

        while (p > 0) {
            temp = temp.next;
            p--;
        }
        Node xNode = new Node(x);
        xNode.next = temp.next;
        xNode.prev = temp;
        temp.next = xNode;
        return head;
    }
}
