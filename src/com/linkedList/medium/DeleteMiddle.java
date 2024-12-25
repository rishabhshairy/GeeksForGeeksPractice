package com.linkedList.medium;

import com.linkedList.ListNode;

public class DeleteMiddle {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = slow;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }


        prev.next = slow.next;
        return head;
    }
}
