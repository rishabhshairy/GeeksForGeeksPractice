package com.heapsPQ;


import java.util.PriorityQueue;

public class MergeMSortedLL {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<Integer> nodeHeap = new PriorityQueue<>();
        for (ListNode node : lists) {
            ListNode temp = node;
            while (temp != null) {
                nodeHeap.add(temp.val);
                temp = temp.next;
            }
        }

        if (nodeHeap.isEmpty()){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (!nodeHeap.isEmpty()) {
            temp.next = new ListNode(nodeHeap.poll());
            temp = temp.next;
        }
        return dummy.next;
    }
}
