package com.linkedList.medium;

import com.linkedList.ListNode;

public class DetectLoop {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow){
                return true;
            }
        }
        return false;
    }
}
