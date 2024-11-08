package com.leetCode.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NMeetingOneRoom {
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5}, end[] = {2, 4, 6, 7, 9, 9};
        System.out.println(new NMeetingOneRoom().maxMeetings(start, end));
    }

    static class Meeting {
        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }

    public int maxMeetings(int start[], int end[]) {
        // add your code here
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }

        Collections.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.endTime - o2.endTime;
            }
        });

        int maxi = 1;
        Meeting currMeeting = meetings.get(0);
        for (int i = 1; i < meetings.size(); i++) {
            if (currMeeting.endTime < meetings.get(i).startTime) {
                maxi++;
                currMeeting = meetings.get(i);
            }
        }
        return maxi;
    }
}
