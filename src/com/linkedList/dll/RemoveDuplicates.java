package com.linkedList.dll;

public class RemoveDuplicates {
    Node removeDuplicates(Node head) {
        // Code Here.
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head.next;

        while (temp != null) {
            if (temp.prev.data == temp.data) {
                temp.prev.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
            }
            temp = temp.next;
        }
        return head;
    }
}
