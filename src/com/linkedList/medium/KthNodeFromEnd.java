package com.linkedList.medium;

import com.linkedList.Node;

public class KthNodeFromEnd {
    int getKthFromLast(Node head, int k) {
        // Your code here
        Node fast = head;
        Node slow = head;
        int count = k;
        while (count > 0 && fast != null) {
            fast = fast.next;
            count--;
        }

        if (count > 0) {
            return -1;
        }

        // now move from slow till fast moves to end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }
}
