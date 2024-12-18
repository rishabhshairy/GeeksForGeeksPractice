package com.leetCode.heaps;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class TwoBestNonOverLapEvents {
    public int maxTwoEvents(int[][] events) {

        // sort array based on start
        Arrays.sort(events, (x, y) -> x[0] - y[0]);

        // create PQ based on end time, PQ --> {end,val}
        PriorityQueue<int[]> eventQueue = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        int maxi = 0, res = 0;

        for (int i = 0; i < events.length; i++) {

            // end time of queue top should be less than next event start time
            while (!eventQueue.isEmpty() && eventQueue.peek()[0] < events[i][0]) {
                int[] currEvent = eventQueue.poll();
                maxi = Math.max(maxi, currEvent[1]); // maximise val

            }

            res = Math.max(res, maxi + events[i][2]);
            eventQueue.offer(new int[]{events[i][1], events[i][2]});
        }
        return res;
    }
}
