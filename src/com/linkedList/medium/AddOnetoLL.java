package com.linkedList.medium;

import com.linkedList.Node;

public class AddOnetoLL {
    /**
     * @param head
     * @return
     */
    public Node addOne(Node head) {

        head = reverseLL(head);
        Node temp = head;

        int carry = 1;

        while (temp != null) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;

            if (temp.next == null && carry == 1) {
                temp.next = new Node(1);
                temp = temp.next;
            }

            temp = temp.next;
        }
        return reverseLL(head);
    }

    private Node reverseLL(Node head) {
        Node curr = head;
        Node temp = null;

        while (curr != null) {
            Node front = curr.next;
            curr.next = temp;
            temp = curr;
            curr = front;
        }
        return temp;
    }

}
