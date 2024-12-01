package com.linkedList.easy;

import com.linkedList.ListNode;

/**
 * LC 237
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        // since we are not given the head, we will operate on node's val
        node.val = 0;
        node.val += node.next.val;
        node.next = node.next.next;
    }
}
