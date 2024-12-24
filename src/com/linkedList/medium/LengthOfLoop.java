package com.linkedList.medium;

import com.linkedList.Node;

public class LengthOfLoop {
    public int countNodesinLoop(Node head) {
        // Add your code here.
        Node slow = head;
        Node fast = head;
        int count = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                count++;
                while (slow.next != fast) {
                    count++;
                    slow = slow.next;
                }
                break;
            }
        }
        return count;
    }
}
