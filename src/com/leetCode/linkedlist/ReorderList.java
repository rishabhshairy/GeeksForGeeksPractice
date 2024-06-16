package com.leetCode.linkedlist;

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

    public ListNode reverseList(ListNode A, int B) {
        ListNode curr = A;
        int count = 0;
        ListNode prev = null, next = null;
        while (curr != null && count < B) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            ListNode ans = reverseList(next, B);
            A.next = ans;
        }
        return prev;
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
            temp = temp.next;
        }
        currLess.next = more.next;
        return less.next;

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = new ListNode(0);
        ListNode pre = temp;
        temp.next = head;

        int i = 0;
        while (i < left) {
            pre = pre.next;
            i++;
        }
        ListNode startRev = pre.next;
        ListNode then = startRev.next;
        i = 0;
        while (i < right - left) {
            ListNode preNext = pre.next;
            ListNode thenNext = then.next;

            pre.next = then;
            then.next = preNext;
            startRev.next = thenNext;
            then = thenNext;

            i++;
        }


        return temp.next;
    }

    public ListNode insertionSortLinkedList(ListNode head) {
        ListNode currTemp = head;
        ListNode sortedHead = null;

        while (currTemp != null) {
            ListNode next = currTemp.next;
            sortedHead = sortedList(sortedHead, currTemp);
            System.out.println(sortedHead.val);
            currTemp = next;
        }
        return sortedHead;
    }

    private ListNode sortedList(ListNode sortedHead, ListNode newNode) {
        if (sortedHead == null || sortedHead.val >= newNode.val) {
            newNode.next = sortedHead;
            return newNode;
        } else {
            ListNode curr = sortedHead;
            while (curr.next != null && curr.next.val < newNode.val) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
            System.out.println(newNode.next.val);
            System.out.println(curr.next.val);
        }
        return sortedHead;
    }

    public ListNode evenReverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode prevOdd = null;

        // seperating and reversing
        while (odd != null && even != null) {

            odd.next = even.next;
            even.next = prevOdd;
            odd = odd.next;
            prevOdd = even;
            if (odd != null) {
                even = odd.next;
            }
        }

        ListNode oddtemp = head;
        ListNode eventemp = head.next;
        ListNode temp = prevOdd; // head of even list

        while (eventemp != null) {
            oddtemp.next = prevOdd;
            temp = prevOdd.next;
            prevOdd.next = eventemp;
            prevOdd = temp;
            oddtemp = eventemp;
            eventemp = eventemp.next;
        }
        if (prevOdd != null) {
            oddtemp.next = prevOdd;
        }
        return head;
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