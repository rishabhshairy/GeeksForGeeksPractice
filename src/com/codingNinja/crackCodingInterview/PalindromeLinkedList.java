package com.codingNinja.crackCodingInterview;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        // Write your code here!
        if (head == null) {
            return true;
        }
        int len = 0;
        List<String> listBuilder = new ArrayList<>();
        while (head != null) {
            len++;
            if (head.data != -1) {
                listBuilder.add(String.valueOf(head.data));
            }
            head = head.next;
        }

        if (len == 1) {
            return true;
        }

        int start = 0;
        int end = listBuilder.size() - 1;
        while (start <= end) {
            if (!listBuilder.get(start++).equals(listBuilder.get(end--))) {
                return false;
            }
        }

        return true;
    }
}

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}