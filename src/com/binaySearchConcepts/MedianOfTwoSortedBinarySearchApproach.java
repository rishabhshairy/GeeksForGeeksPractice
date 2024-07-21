package com.binaySearchConcepts;

public class MedianOfTwoSortedBinarySearchApproach {
    public static void main(String[] args) {
        int[] a = {2, 4, 6};
        int[] b = {1, 3};
        System.out.println(median(a, b));
    }

    public static double median(int[] a, int[] b) {

        int n1 = a.length;
        int n2 = b.length;

        // swap arrays if n1 > n2 to always perform ops on smaller array
        if (n1 > n2) {
            return median(b, a);
        }

        // vars for binary search
        int totalLengthOfMergedArray = n1 + n2; // total length
        int low = 0;
        int high = n1;
        int oddLeft = (n1 + n2 + 1) / 2; // finding no of elements to take from right
        while (low <= high) {

            int mid1 = (low + high) >> 1;   // to be used on  smaller array --> primarily left array
            int mid2 = oddLeft - mid1;      // to be used on larger array --> primarily right array
            int left1 = Integer.MIN_VALUE, left2 = Integer.MIN_VALUE, right1 = Integer.MAX_VALUE, right2 = Integer.MAX_VALUE;

            // check for boundary conditions
            if (mid1 < n1) {
                right1 = a[mid1];   // setting value on right half of smaller array
            }
            if (mid2 < n2) {
                right2 = b[mid2];   // setting value on right half of larger array
            }

            if (mid1 - 1 >= 0) {
                left1 = a[mid1 - 1];  // setting value of max left on left half of smaller array
            }
            if (mid2 - 1 >= 0) {
                left2 = b[mid2 - 1];  // setting value of max left on left half of larger array
            }

            // now cross compare
            if (left1 <= right2 && left2 <= right1) {
                if (totalLengthOfMergedArray % 2 == 1) {
                    return (double) Math.max(left1, left2);
                } else {
                    return (double) (Math.max(left1, left2) + Math.min(right1, right2)) / 2;
                }
            } else if (left1 > right2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }

        }

        return 0;
    }
}
