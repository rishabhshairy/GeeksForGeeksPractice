package com.linkedList.medium;

import com.linkedList.ListNode;

import java.util.Stack;

public class PalindromeLL {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> nodeStack = new Stack<>();

        ListNode temp = head;
        while (temp != null) {
            nodeStack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (!nodeStack.isEmpty()) {
            if (nodeStack.pop() == temp.val) {
                temp = temp.next;
            } else {
                return false;
            }
        }
        return nodeStack.isEmpty();
    }
}
