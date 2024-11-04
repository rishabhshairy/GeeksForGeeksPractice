package com.leetCode.greedy;

import java.util.*;

public class FractionalKnapsack {
    static class Item {
        Integer value;
        Integer weight;

        public Item(Integer value, Integer weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    double fractionalKnapsack(List<Integer> values, List<Integer> weights, int w) {
        // code here
        int n = values.size();
        Item[] arr = new Item[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Item(values.get(i), weights.get(i));
        }

        Arrays.sort(arr, (o1, o2) -> {
            double item1 = (double) o1.value / (double) o1.weight;
            double item2 = (double) o2.value / (double) o2.weight;

            // this is for decreasing order
            if (item1 < item2) {
                return 1;
            } else if (item1 > item2) {
                return -1;
            } else {
                return 0;
            }
        });

        double maxAmount = 0;
        int currWeight = 0;

        for (int i = 0; i < arr.length; i++) {
            if (currWeight + arr[i].weight <= w) {
                currWeight += arr[i].weight;
                maxAmount += arr[i].value;
            } else {
                int remainingWeight = w - currWeight;
                maxAmount += ((double) arr[i].value/(double) arr[i].weight) * (double) remainingWeight;
                break;
            }
        }
        return maxAmount;
    }
}
