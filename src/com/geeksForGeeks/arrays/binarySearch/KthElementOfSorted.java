package com.geeksForGeeks.arrays.binarySearch;

public class KthElementOfSorted {
    public static void main(String[] args) {
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
        int k = 5;
        //System.out.println(kthElementBruteForce(arr1, arr2, arr1.length, arr2.length, k));
        System.out.println(kthElement(arr1, arr2, arr1.length, arr2.length, k));
    }

    /**
     * This is binary search approach
     *
     * @param a
     * @param b
     * @param n
     * @param m
     * @param k
     * @return
     */
    public static long kthElement(int a[], int b[], int n, int m, int k) {

        if (n > m) {
            return kthElementBruteForce(b, a, m, n, k);
        }

        int leftHalfLength = k;  // since we can have max K elements in left half
        int low = Math.max(0, k - m); // because we need to pick atleast 1 element from left array in case k > m
        int high = Math.min(k, n);   // because we can pick max n elements from left array if k > n

        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = leftHalfLength - mid1;

            int left1 = mid1 - 1 >= 0 ? a[mid1 - 1] : Integer.MIN_VALUE;
            int left2 = mid2 - 1 >= 0 ? b[mid2 - 1] : Integer.MIN_VALUE;
            int right1 = mid1 < n ? a[mid1] : Integer.MAX_VALUE;
            int right2 = mid2 < m ? b[mid2] : Integer.MAX_VALUE;

            // now compare

            if (left1 <= right2 && left2 <= right1) {
                return Math.max(left1, left2);
            } else if (left1 > right2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }


        return 0;
    }

    /**
     * Solution similar to Median of two sorted array
     * We just need to find kth element during virtual merging
     *
     * @param a
     * @param b
     * @param n
     * @param m
     * @param k
     * @return
     */
    public static long kthElementBruteForce(int a[], int b[], int n, int m, int k) {
        int indexCounter = 0;
        int i = 0, j = 0;
        long ans = -1;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                if (indexCounter == k - 1) {
                    ans = a[i];
                }
                i++;
                indexCounter++;
            } else {
                if (indexCounter == k - 1) {
                    ans = b[j];
                }
                j++;
                indexCounter++;
            }
        }

        while (i < n) {
            if (indexCounter == k - 1) {
                ans = a[i];
            }
            i++;
            indexCounter++;
        }

        while (j < n) {
            if (indexCounter == k - 1) {
                ans = b[j];
            }
            j++;
            indexCounter++;
        }
        return ans;
    }
}
