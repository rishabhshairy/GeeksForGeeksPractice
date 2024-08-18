package com.geeksForGeeks.linkedlist;

public class IntersectionPoint {
    public static void main(String[] args) {

    }

    int intersectPoint(Node head1, Node head2) {
        // code here
        while (head1 != null) {
            head1.data = head1.data + 10000;
            head1 = head1.next;
        }
        while (head2 != null) {
            if (head2.data > 10000)
                return (head2.data) - 10000;
            head2 = head2.next;
        }
        return -1;
    }

    //Node of a linked list
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}