package com.binaySearchConcepts;

public class FloorAndCeilCodingNinja {
    public static void main(String[] args) {

    }

    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        // Write your code here.
        int[] ans = new int[2];
        findFloor(a, n, x, ans);
        findCeil(a, n, x, ans);
        return ans;
    }

    /**
     * Finding Ceil is similar to finding lower bound
     *
     * @param arr
     * @param length
     * @param x
     * @param ans
     */
    private static void findCeil(int[] arr, int length, int x, int[] ans) {
        int ceil = -1;
        int low = 0;
        int high = length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                ceil = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        ans[1] = ceil;
    }

    private static void findFloor(int[] arr, int length, int x, int[] ans) {
        int floor = -1;
        int low = 0;
        int high = length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= x) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        ans[0] = floor;
    }
}
