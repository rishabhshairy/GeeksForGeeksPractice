package com.leetCode.stack;

import java.util.Stack;

public class MaxChunksToMakeSorted {

    /**
     * Max element approach
     *
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int maxi = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
            if (i == maxi) {
                count++;
            }
        }
        return count;
    }

    /**
     * Stack Approach
     *
     * @param arr
     * @return
     */
    public int maxChunksToSortedStackApproach(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            // push maximum on to stack
            if (st.empty() || arr[i] > st.peek()) {
                st.push(arr[i]);
            } else {
                // Case 2 merge
                int maxi = st.peek();
                while (!st.empty() && arr[i] < st.peek()) {
                    st.pop();
                }
                // push back max to top
                st.push(maxi);
            }
        }
        return st.size();
    }
}
