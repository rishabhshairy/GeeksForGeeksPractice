package com.geeksForGeeks.arrays.level1;

import java.util.*;

public class UnionOfArray {
    public static void main(String[] args) {
        int n = 10;
        int m = 7;
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};
        System.out.println(findUnion(arr1, arr2, n, m));
    }

    // this solution works for both sorted and unsorted array
/*    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        // add your code here

        //int[] mergedList = new int[n + m];
        Set<Integer> removeDups = new LinkedHashSet<Integer>();
        while (n > 0) {
            n--;
            removeDups.add(arr1[n]);
        }
        while (m > 0) {
            m--;
            removeDups.add(arr2[m]);
        }
        ArrayList<Integer> result = new ArrayList<>(removeDups);
        Collections.sort(result);
        return result;
    }*/

    /**
     * Taking advantage that array is sorted
     */
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {

        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                // check if last element is not arr[i]
                if (result.size() == 0 || result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                }
                i++;
            } else {
                if (result.size() == 0 || result.get(result.size() - 1) != arr2[j]) {
                    result.add(arr2[j]);
                }
                j++;
            }
        }
        // add left out  elements
        while (i < n) {
            if (result.get(result.size() - 1) != arr1[i]) {
                result.add(arr1[i]);
            }
            i++;
        }

        while (j < m) {
            if (result.get(result.size() - 1) != arr2[j]) {
                result.add(arr2[j]);
            }
            j++;
        }
        return result;
    }
}
