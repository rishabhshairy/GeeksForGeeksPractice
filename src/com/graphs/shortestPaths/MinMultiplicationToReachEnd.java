package com.graphs.shortestPaths;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinMultiplicationToReachEnd {
    public static void main(String[] args) {
        int[] arr = {3, 4, 65};
        MinMultiplicationToReachEnd obj = new MinMultiplicationToReachEnd();
        int i = obj.minimumMultiplications(arr, 7, 66175);
        System.out.println(i);
    }

    static class StepNum {
        int steps;
        int num;

        public StepNum(int steps, int num) {
            this.steps = steps;
            this.num = num;
        }
    }

    int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }
        int[] distance = new int[100000];
        Arrays.fill(distance, (int) 1e9);
        distance[start] = 0;

        Queue<StepNum> numQueue = new LinkedList<>();
        numQueue.offer(new StepNum(0, start));

        while (!numQueue.isEmpty()) {
            StepNum curr = numQueue.poll();
            int currNum = curr.num;
            int currStep = curr.steps;

            for (int i = 0; i < arr.length; i++) {
                int nextNum = (currNum * arr[i]) % (100000);
                int nextStep = currStep + 1;

                if (nextStep < distance[nextNum]) {
                    distance[nextNum] = nextStep;
                    if (nextNum == end) {
                        return nextStep;
                    }
                    numQueue.offer(new StepNum(nextStep, nextNum));
                }
            }
        }
        return -1;
    }
}
