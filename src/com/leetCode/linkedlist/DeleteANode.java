package com.leetCode.linkedlist;

public class DeleteANode {
    public static void main(String[] args) {

    }

    public static void deleteNode(LinkedListNode<Integer> node) {
        // Write your code here.
        node.data = node.next.data;
        node.next = node.next.next;
    }

    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        LinkedListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
