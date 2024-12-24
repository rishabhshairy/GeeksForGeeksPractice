package com.linkedList.dll;

import java.util.Stack;

public class ReverseDLL {
    static class DLLNode {
        int data;
        DLLNode next;
        DLLNode prev;

        DLLNode(int val) {
            data = val;
            next = null;
            prev = null;
        }
    }

    public DLLNode reverseDLL(DLLNode head) {
        DLLNode curr = head;
        DLLNode temp = null;

        while (curr != null) {
            // storing ref to previous node
            temp = curr.prev;
            // swap prev and next pointers
            curr.prev = curr.next;
            // reverse the link
            curr.next = temp;
            // move to next node
            curr = curr.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
        return head;
    }

    /**
     * Stack Approach
     *
     * @param head
     * @return
     */
    public DLLNode reverseDLLStack(DLLNode head) {
        // Your code here
        DLLNode temp = head;
        Stack<Integer> nodeStack = new Stack<>();

        while (temp.next != null) {
            nodeStack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            temp.data = nodeStack.pop();
            temp = temp.next;
        }
        return head;
    }
}
