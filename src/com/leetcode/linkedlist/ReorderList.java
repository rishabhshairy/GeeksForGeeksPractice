package com.leetcode.linkedlist;

public class ReorderList {
    public ListNode reorderList(ListNode A) {
        int len = size(A);
        if (len <= 2) {
            return A;
        }

        ListNode temp = A;
        int i = 0;
        while (i < len / 2) {
            temp = temp.next;
            i++;
        }
        ListNode otherHalf = reverseList(temp.next);
        temp.next = null;
        temp = A;

        while (otherHalf != null) {
            ListNode curr = otherHalf;
            otherHalf = otherHalf.next;
            curr.next = temp.next;
            temp.next = curr;

            temp = temp.next.next;

        }
        return A;
    }

    static int size(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    static ListNode reverseList(ListNode head) {
        ListNode curr = head, pre = null;

        while (curr != null) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = pre;
            pre = temp;
        }
        return pre;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = size(l1);
        int len2 = size(l2);

        if (len1 > len2) {
            int i = len1 - len2;
            ListNode temp = l2;
            while (temp.next != null) {
                temp = temp.next;
            }
            while (i-- > 0) {
                temp.next = new ListNode(0, null);
                temp = temp.next;
            }
        } else if (len1 < len2) {
            int i = len2 - len1;
            ListNode temp = l1;
            while (temp.next != null) {
                temp = temp.next;
            }
            while (i-- > 0) {
                temp.next = new ListNode(0, null);
                temp = temp.next;
            }
        }
        ListNode tempA = l1;
        ListNode pre = l1;
        ListNode tempB = l2;
        int carry = 0;
        while (tempA != null && tempB != null) {
            int sum = tempA.val + tempB.val;
            if (sum < 10) {
                tempA.val = sum;
                carry = 0;
            } else {
                carry = sum / 10;
                tempA.val = sum % 10;
            }
            pre = tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }

        if (carry == 1) {
            pre.next = new ListNode(carry, null);
        }
        return l1;
    }

    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode();
        ListNode currLess = less;

        ListNode more = new ListNode();
        ListNode currMore = more;


        ListNode temp = head;

        while (temp != null) {
            ListNode node = temp;
            if (temp.val < x) {
                currLess.next = node;
                currLess = currLess.next;
            } else {
                currMore.next = node;
                currMore = currMore.next;
            }
        }
        currLess.next = more.next;
        return less.next;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}