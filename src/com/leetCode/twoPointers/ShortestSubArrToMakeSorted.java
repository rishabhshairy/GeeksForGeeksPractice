package com.leetCode.twoPointers;

public class ShortestSubArrToMakeSorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 10, 4, 2, 3, 5};
        findLengthOfShortestSubarrayTwoPointer(arr);
    }

    /**
     * Two Pointer Approach
     *
     * @param arr
     * @return
     */
    public static int findLengthOfShortestSubarrayTwoPointer(int[] arr) {
        int n = arr.length;
        int leftInc = 0;
        int rightInc = n - 1;

        while (leftInc < n - 1 && arr[leftInc] <= arr[leftInc + 1]) {
            leftInc++;
        }

        // check if whole array is sorted
        if (leftInc == n - 1) {
            return 0;
        }

        // check for right increasing from end
        while (rightInc > 0 && arr[rightInc - 1] <= arr[rightInc]) {
            rightInc--;
        }

        // now join elements from both check points
        int minLen = Math.min(n - leftInc - 1, rightInc);



        int i = 0;
        while (i <= leftInc && rightInc < n) {
            if (arr[i] <= arr[rightInc]) {
                minLen = Math.min(minLen, rightInc - i - 1);
                i++;
            } else {
                rightInc++;
            }
        }
//        System.out.println(minLen);
        return minLen;
    }
}
