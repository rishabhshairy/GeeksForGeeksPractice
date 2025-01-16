package com.linkedList.medium;

import com.linkedList.ListNode;

public class DeleteFromNthEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int count = n;

        while (count > 0 && fast != null) {
            fast = fast.next;
            count--;
        }

        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
