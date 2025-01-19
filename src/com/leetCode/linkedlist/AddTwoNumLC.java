package com.leetCode.linkedlist;

import java.util.Stack;

public class AddTwoNumLC {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while (temp1 != null) {
            stack1.push(temp1.val);
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            stack2.push(temp2.val);
            temp2 = temp2.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        int carry = 0;

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.pop() + stack2.pop() + carry;
            carry = sum / 10;
            ListNode curr = new ListNode(sum % 10);
            temp.next = curr;
            temp = temp.next;
        }

        // add to sum
        while (!stack1.isEmpty()) {
            int sum = stack1.pop() + carry;
            carry = sum / 10;
            ListNode curr = new ListNode(sum % 10);
            temp.next = curr;
            temp = temp.next;
        }

        while (!stack2.isEmpty()) {
            int sum = stack2.pop() + carry;
            carry = sum / 10;
            ListNode curr = new ListNode(sum % 10);
            temp.next = curr;
            temp = temp.next;
        }

        if (carry == 1) {
            temp.next = new ListNode(carry);
        }

        return reverseLL(dummy.next);
    }

    private ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempHead = reverseLL(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return tempHead;
    }
}
