package com.linkedList.medium;

import com.linkedList.Node;

import java.util.ArrayList;
import java.util.List;

public class RemoveLoop {
    public static Node removeLoop(Node head) {
        List<Node> nodes = new ArrayList<>();

        Node temp = head;
        while (temp != null) {
            if (nodes.contains(temp.next)) {
                temp.next=null;
                break;
            } else {
                nodes.add(temp);
                temp = temp.next;
            }
        }
        return head;
    }
}
