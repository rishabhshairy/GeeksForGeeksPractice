package com.binaySearchConcepts;

/**
 * The lower bound algorithm finds the first or the smallest index in a sorted array
 * where the value at that index is greater than or equal to a given key i.e. x.
 * <p>
 * The lower bound is the smallest index, ind, where arr[ind] >= x. But if any such index is not found,
 * the lower bound algorithm returns n i.e. size of the given array
 */
public class LowerBoundConcept {
    public static void main(String[] args) {
        System.out.print(findLowerBound(new int[]{3,4,4,7,8,10}, 2));
    }

    public static int findLowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length; // setting hypothetical answer if we dont find any such number

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
