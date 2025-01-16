package com.heapsPQ;

import java.util.*;

public class MaxSumCombination {
    public static void main(String[] args) {
        int N = 2;
        int K = 2;
        int A[] = {3, 2};
        int B[] = {1, 4};
        maxCombinations(N, K, A, B);
    }

    static List<Integer> maxCombinations(int n, int k, int a[], int b[]) {
        // code here
        List<Integer> result = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> x - y);

        for (int i = n - 1; i > n - k - 1; i--) {
            for (int j = n - 1; j > n - k - 1; j--) {
                int sum = a[i] + b[j];
                System.out.println(sum);
                if (maxHeap.size() < k) {
                    maxHeap.add(sum);
                } else if (sum > maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.add(sum);
                } else {
                    break;
                }
            }
        }
        System.out.println(maxHeap);
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll());
        }
        return result;
    }
}
