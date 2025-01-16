package com.leetCode.greedy;

import com.codingNinja.crackCodingInterview.easy.CollinearPointsInLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JobSequencing {
    public static void main(String[] args) {
        int[] id = {1, 2, 3, 4};
        int[] deadline = {4, 1, 1, 1};
        int[] profit = {20, 1, 40, 30};

        JobSequencing obj = new JobSequencing();
        System.out.println(obj.JobSequencing(id, deadline, profit));
    }

    static class Job {
        int id;
        int deadline;
        int profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "id=" + id +
                    ", deadline=" + deadline +
                    ", profit=" + profit +
                    '}';
        }
    }

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        // code here..
        int n = profit.length;
        ArrayList<Job> jobs = new ArrayList<>(2);
        int maxDeadline = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(id[i], deadline[i], profit[i]));
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        jobs.sort((x, y) -> y.profit - x.profit);
        int[] timeSlot = new int[maxDeadline + 1];
        Arrays.fill(timeSlot, -1);
        int maxProfit = 0;
        int maxJobs = 0;
        for (int i = 0; i < jobs.size(); i++) {
            int currDeadline = jobs.get(i).deadline;
            int currJobId = jobs.get(i).id;
            int currProfit = jobs.get(i).profit;

            for (int j = currDeadline; j > 0; j--) {
                if (timeSlot[j] == -1) {
                    timeSlot[j] = currJobId;
                    maxJobs++;
                    maxProfit += currProfit;
                    break;
                }
            }


        }

        return new ArrayList<>(List.of(maxJobs, maxProfit));
    }
}
