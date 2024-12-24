package com.linkedList.medium;

import com.linkedList.ListNode;

public class MidOfLL {
    /**
     * One approach find length
     * and then find
     * this will need 2 traversal
     * <p>
     * We will use Slow and Fast pointer algo
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
