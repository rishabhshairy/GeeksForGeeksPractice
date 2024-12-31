package com.linkedList.hard;

import java.util.ArrayList;
import java.util.Collections;

public class FlattenLinkList {
    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int x) {
            data = x;
            next = null;
            bottom = null;
        }
    }

    Node flatten(Node root) {
        // code here
        ArrayList<Integer> nums = new ArrayList<>();

        Node temp = root;

        while (temp != null) {
            Node sub = temp;
            while (sub != null) {
                nums.add(sub.data);
                sub = sub.bottom;
            }
            temp = temp.next;
        }

        Collections.sort(nums);
        Node head = new Node(-1);
        Node dummy = head;
        temp = head;
        for (Integer num : nums) {
            temp.next = new Node(num);
            temp = temp.next;
        }
        return dummy.next;
    }

}
