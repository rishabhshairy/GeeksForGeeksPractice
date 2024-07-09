package com.geeksForGeeks.arrays.level1;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeader {
    public static void main(String[] args) {
        System.out.println(leaders(6, new int[]{16, 17, 4, 3, 5, 2}));
    }

    public static ArrayList<Integer> leaders(int n, int[] arr) {
        // Your code here
        ArrayList<Integer> leaderList = new ArrayList<>();
        int max = arr[n - 1];
        leaderList.add(max);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                leaderList.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(leaderList);
        return leaderList;
    }
}
