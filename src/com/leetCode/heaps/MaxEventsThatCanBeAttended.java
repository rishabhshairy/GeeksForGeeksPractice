package com.leetCode.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxEventsThatCanBeAttended {
    public static void main(String[] args) {
        int[][] events = {{1, 2}, {1, 2}, {1, 5}, {1, 5}, {3, 3}};
        maxEvents(events);
    }

    public static int maxEvents(int[][] events) {

        Arrays.sort(events, Comparator.comparingInt(i -> i[0]));
        int index = 0, maxEventsAttend = 0;
        int totalEvents = events.length;

        PriorityQueue<Integer> evenEndDayQueue = new PriorityQueue<>();

        for (int currentDay = 1; currentDay <= 100000; currentDay++) {

            // events[index][0] == startDay
            while (index < totalEvents && events[index][0] == currentDay) {
                evenEndDayQueue.add(events[index++][1]);
            }

            // Remove from queue if event is over
            while (!evenEndDayQueue.isEmpty() && evenEndDayQueue.peek() < currentDay) {
                evenEndDayQueue.poll();
            }

            if (!evenEndDayQueue.isEmpty()){
                maxEventsAttend++;
                evenEndDayQueue.poll();
            }
        }

        return maxEventsAttend;
    }

}
