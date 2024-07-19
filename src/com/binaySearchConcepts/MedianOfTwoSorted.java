package com.binaySearchConcepts;

/**
 * This will contain solution for both equal and unequal array
 */
public class MedianOfTwoSorted {

    public static void main(String[] args) {
        int[] a = {2, 4, 6};
        int[] b = {1, 3, 5};
        System.out.println(medianWithoutMerge(a, b));
    }


    public static double medianWithoutMerge(int[] a, int[] b) {
        int i = 0, j = 0, indexTracker = 0;
        int totalLength = a.length + b.length;

        // now find out indexes
        int index2 = totalLength / 2; // directly return in case of odd total length
        int index1 = index2 - 1;

        int indexElement1 = -1;
        int indexElement2 = -1;

        // now without merging try to find out the median

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {

                if (indexTracker == index1) {
                    indexElement1 = a[i];
                }
                if (indexTracker == index2) {
                    indexElement2 = a[i];
                }
                indexTracker++;
                i++;

            } else {
                if (indexTracker == index1) {
                    indexElement1 = b[j];
                }
                if (indexTracker == index2) {
                    indexElement2 = b[j];
                }
                indexTracker++;
                j++;
            }
        }
        // now check in left out elements
        while (i < a.length) {
            if (indexTracker == index1) {
                indexElement1 = a[i];
            }
            if (indexTracker == index2) {
                indexElement2 = a[i];
            }
            indexTracker++;
            i++;
        }

        while (j < b.length) {
            if (indexTracker == index1) {
                indexElement1 = b[j];
            }
            if (indexTracker == index2) {
                indexElement2 = b[j];
            }
            indexTracker++;
            j++;
        }

        if (totalLength % 2 == 1) {
            return indexElement2;
        }

        // for even, we need to type cast and return
        return (double) (indexElement1 + indexElement2) / 2;
    }

    /**
     * This is brute force approach
     * if n == even --> median = (n/2) + (n/2 - 1 )
     * if n == odd --> median = ( n/2 )
     *
     * @param a
     * @param b
     * @return
     */
    public static double median(int[] a, int[] b) {
        // Write your code here.
        double median = 0;

        int[] mergedArr = new int[a.length + b.length];
        int i = 0; // to iterate over a
        int j = 0; // to iterate over b
        int k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                mergedArr[k++] = a[i++];
            } else {
                mergedArr[k++] = b[j++];
            }
        }

        // now add left out elements first a and then b

        while (i < a.length) {
            mergedArr[k++] = a[i++];
        }

        while (j < b.length) {
            mergedArr[k++] = b[j++];
        }

        // now check for total length of merged array and find median
        int n = mergedArr.length;

        if (n % 2 == 0) {
            return (double) (mergedArr[n / 2] + mergedArr[(n / 2) - 1]) / 2;
        } else {
            return (double) mergedArr[n / 2];
        }
    }
}
