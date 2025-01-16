package com.company.FlexPortOA;

import java.util.Arrays;

public class CollectPoints {
    public static void main(String[] args) {
        int[] players = {500};
        int[] points = {1,1000};
        int n = players.length;
        int m = points.length;

        Arrays.sort(players);
        Arrays.sort(points);
        int maxTime = 0;

        for (int point : points) {
            int index = Arrays.binarySearch(players, point);
            index = index >= 0 ? index : -index - 1;

            int distance = 0;
            if (index == 0) {
                distance = Math.abs(players[0] - point);
            } else if (index == n) {
                distance = Math.abs(players[n - 1] - point);
            } else {
                distance = Math.min(Math.abs(players[index] - point), Math.abs(players[index - 1] - point));
            }
            maxTime = Math.max(maxTime, distance);
        }
        System.out.println(maxTime);
    }
}
