package com.geeksForGeeks.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinCoins {
    public static void main(String[] args) {
        minPartition(43);
    }

    static List<Integer> minPartition(int N) {
        int[] denominations = {1,2,5,10,20,50,100,200,500,2000};
        List<Integer> ans = new ArrayList<>();

        for(int i = denominations.length - 1; i >= 0; i--) {
            while (N >= denominations[i] && N/denominations[i] > 0) {
                ans.add(denominations[i]);
                N -= denominations[i];
            }
        }

        return ans;
    }
}
