package com.linkedList.hard;

import com.linkedList.ListNode;

public class ReverseKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;

        // to store last node of kth group
        ListNode prevLast = null;

        while (temp != null) {
            ListNode kThNode = getKthNode(temp, k);

            // incomplete group, link prevLast to current node
            if (kThNode == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }

            // now reverse from kth node
            ListNode nextNode = kThNode.next;
            kThNode.next = null;
            reverseLL(temp);

            // Adjust head if reversal starts from head
            if (temp == head) {
                head = kThNode;
            } else {
                // Link the last node of the previous
                // group to the reversed group
                prevLast.next = kThNode;
            }

            prevLast = temp;
            temp = nextNode;
        }
        return head;
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

    private ListNode getKthNode(ListNode temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }
}
