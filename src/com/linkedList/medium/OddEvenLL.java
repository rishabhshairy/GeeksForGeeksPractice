package com.linkedList.medium;

import com.linkedList.ListNode;

public class OddEvenLL {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head;
        head = odd;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            even = even.next;
            odd = odd.next;
        }
        odd.next = evenHead;
        return head;
    }
}
