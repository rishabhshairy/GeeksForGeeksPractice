package com.codingNinja.crackCodingInterview.easy;

public class IntersectionOfLinkedList {
    public static void main(String[] args) {

    }

    public static int findIntersection(Node firstHead, Node secondHead) {
        //Write your code here
        while (firstHead != null) {
            firstHead.data = firstHead.data + 10000;
            firstHead = firstHead.next;
        }
        while (secondHead != null) {
            if (secondHead.data > 10000)
                return (secondHead.data) - 10000;
            secondHead = secondHead.next;
        }
        return -1;
    }
    static class Node {
        public int data;
        public Node next;

        Node() {
            this.data = 0;
            this.next = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}

