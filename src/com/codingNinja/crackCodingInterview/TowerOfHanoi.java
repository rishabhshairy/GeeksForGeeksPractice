package com.codingNinja.crackCodingInterview;

import java.util.ArrayList;

public class TowerOfHanoi {
    public static void main(String[] args) {
        System.out.println(towerOfHanoi(3));
    }

    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int n) {
        //    Write your code here.
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        solve(n, 1, 2, 3, result);
        return result;
    }

    private static void solve(int n, int start, int aux, int destination, ArrayList<ArrayList<Integer>> result) {
        if (n == 0) {
            return;
        }
        solve(n - 1, start, destination, aux, result);
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(start);
        temp.add(aux);
        result.add(temp);
        solve(n - 1, destination, aux, start, result);

    }
}
