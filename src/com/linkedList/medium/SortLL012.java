package com.linkedList.medium;

import com.linkedList.Node;

public class SortLL012 {
    static Node segregate(Node head) {
        // add your code here
        if (head == null || head.next == null) {
            return head;
        }

        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;

        Node curr = head;

        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        if (oneHead.next != null) {
            zero.next = oneHead.next;
        } else {
            zero.next = twoHead.next;
        }

        if (twoHead.next != null) {
            one.next = twoHead.next;
        } else {
            one.next = null;
        }
        two.next = null;

        return zeroHead.next;
    }
}
