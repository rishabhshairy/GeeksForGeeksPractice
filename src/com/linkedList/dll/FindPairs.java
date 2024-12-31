package com.linkedList.dll;

import java.util.ArrayList;

public class FindPairs {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        Node last = head;
        Node first = head;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        while (last.next != null) {
            last = last.next;
        }

        while (first.data < last.data) {
            int sum = first.data + last.data;
            if (sum == target) {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(first.data);
                arr.add(last.data);
                result.add(arr);
                last = last.prev;
                first = first.next;
            }

            else if (sum > target) {
                last = last.prev;
            } else {
                first = first.next;
            }
        }
        return result;
    }
}
