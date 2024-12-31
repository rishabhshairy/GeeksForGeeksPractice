package com.linkedList.medium;

import com.linkedList.ListNode;

public class ReverseLL {
    /**
     * Iterative
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode temp = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode front = curr.next;
            curr.next = temp;
            temp = curr;
            curr = front;
        }
        return temp;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecursive(head.next);
        // save reference
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}
