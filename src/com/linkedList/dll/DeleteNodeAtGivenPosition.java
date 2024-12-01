package com.linkedList.dll;

public class DeleteNodeAtGivenPosition {
    /**
     * @param head
     * @param x    -> denotes position
     * @return
     */
    public Node deleteNode(Node head, int x) {
        // code here
        int count = 1;
        Node temp = head;
        while (temp != null) {
            if (count == x) {
                if (temp.next != null) {
                    temp.data = temp.next.data;
                    temp.next = temp.next.next;
                } else {
                    //last element
                    temp.prev.next = null;
                }
                if (temp.next != null) {
                    temp.next.prev = temp;
                }
            }
            temp = temp.next;
            count++;
        }
        return head;
    }
}
