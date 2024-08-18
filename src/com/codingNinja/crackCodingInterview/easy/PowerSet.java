package com.codingNinja.crackCodingInterview.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PowerSet {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
//        System.out.println(pwset(arr));
        System.out.println(pwsetUsingBitManipulation(arr));
    }

    public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
        // WRITE YOUR CODE HERE
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currSet = new ArrayList<>();
        int n = arr.size();
        solveUsingRecursion(0, n, currSet, arr, result);
        //Collections.sort(result);
        return result;
    }

    private static void solveUsingRecursion(int index, int n, ArrayList<Integer> currSet, ArrayList<Integer> arr,
                                            ArrayList<ArrayList<Integer>> result) {
        if (index == n) {

            result.add(new ArrayList<>(currSet));
            return;
        }

        // using pick and non-pick approach
        currSet.add(arr.get(index));
        solveUsingRecursion(index + 1, n, currSet, arr, result);

        // remove when not picking
        currSet.remove(currSet.size() - 1);
        solveUsingRecursion(index + 1, n, currSet, arr, result);

    }

    public static ArrayList<ArrayList<Integer>> pwsetUsingBitManipulation(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currSet;

        for (int num = 0; num < Math.pow(2, arr.size()); num++) {
            currSet = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                if ((num & (1 << i)) != 0) {
                    currSet.add(arr.get(i));
                }
            }
            result.add(currSet);
        }
        return result;
    }
}
