package com.linkedList.easy;

import com.linkedList.Node;

public class ArrToLL {
    static Node constructLL(int arr[]) {
        // code here
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }
}
