package com.binaySearchConcepts;

import java.util.ArrayList;
import java.util.Collections;

public class PainterPartition {
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        //    Write your code here.
        int n = boards.size();
        int maxTimeUnit = Collections.max(boards);
        int totalTimeSum = boards.stream().mapToInt(Integer::intValue).sum();

        // now apply binary search
        int low = maxTimeUnit;
        int high = totalTimeSum;

        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println(mid);
            if (isPossibleToPaint(boards, mid) > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int isPossibleToPaint(ArrayList<Integer> boards, int time) {
        int currPainter = 1;
        int currTime = 0;

        for (Integer unitTime :
                boards) {
            if (currTime + unitTime <= time) {
                currTime += unitTime;
            } else {
                currPainter++;
                currTime = unitTime;
            }
        }
        return currPainter;
    }
}
