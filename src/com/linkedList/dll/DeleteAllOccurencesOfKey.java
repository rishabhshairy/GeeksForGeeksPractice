package com.linkedList.dll;

public class DeleteAllOccurencesOfKey {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = prev = null;
        }
    }

    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        if (head.next == null && head.data == x) {
            return null;
        }
        Node dummy = new Node(-1);
        dummy.next = head;

        Node curr = head;
        Node prev = dummy;

        while (curr != null) {

            if (curr.data == x) {
                prev.next = curr.next;

                // check if it's not last node
                if (curr.next != null) {
                    curr.next.prev = prev;
                }
                // move to next
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
