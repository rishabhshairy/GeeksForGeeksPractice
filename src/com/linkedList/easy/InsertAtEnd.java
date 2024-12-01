package com.linkedList.easy;

import com.linkedList.Node;

public class InsertAtEnd {
    Node insertAtEnd(Node head, int x) {
        // code here
        if (head==null){
            return new Node(x);
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(x);
        return head;
    }
}
