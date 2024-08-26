package com.codingNinja.crackCodingInterview.easy;

import java.util.ArrayList;

public class SparseSearch {
    public static void main(String[] args) {

    }

    public static int sparseSearch(ArrayList<String> arr, String k) {
        // Write your code here.
        int low = 0;
        int high = arr.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr.get(mid).equals("")) {
                int left = mid - 1;
                int right = mid + 1;

                while (left >= low || right <= high) {
                    if (left >= 0 && left >= low && !arr.get(left).equals("")) {
                        mid = left;
                        break;
                    }
                    if (right < arr.size() && right <= high && !arr.get(right).equals("")) {
                        mid = right;
                    }
                    left--;
                    right++;
                }
            }
            if (k.compareTo(arr.get(mid)) == 0) {
                return mid;
            } else if (k.compareTo(arr.get(mid)) > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }
}
