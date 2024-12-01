package com.linkedList.dll;

public class ConstructDLL {
    Node constructDLL(int arr[]) {
        // Code here
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp.next.prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
