package com.binaySearchConcepts;

/**
 * The upper bound algorithm finds the first or the smallest index in a
 * sorted array where the value at that index is greater than the given key i.e. x.
 * <p>
 * The upper bound is the smallest index, ind, where arr[ind] > x.
 */
public class UpperBoundConcept {
    public static void main(String[] args) {
        System.out.print(findUpperBound(new int[]{3, 5, 8, 15, 19}, 20));
    }

    public static int findUpperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length; // setting hypothetical answer if we dont find any such number

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
