package com.linkedList.medium;

import com.linkedList.ListNode;

public class SortLLUsingMergeSort {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // first find middle
        ListNode middleNode = findMiddle(head);

        ListNode right = middleNode.next;
        middleNode.next = null;
        ListNode left = head;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        // travel simultaneously and merge back
        while (left != null && right != null) {
            if (left.val <= right.val) {
                temp.next = left;
                temp = left;
                left = left.next;
            } else {
                temp.next = right;
                temp=right;
                right = right.next;
            }

        }

        // append remaining list
        if (left != null) {
            temp.next = left;
        } else {
            temp.next = right;
        }

        return dummy.next;
    }

    private ListNode findMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
