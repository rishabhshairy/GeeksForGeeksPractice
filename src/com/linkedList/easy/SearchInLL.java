package com.linkedList.easy;

import com.linkedList.Node;

public class SearchInLL {
    static boolean searchKey(int n, Node head, int key) {
        // Code here
        while (head!=null){
            if (key==head.data){
                return true;
            }
            head=head.next;
        }
        return false;
    }
}
