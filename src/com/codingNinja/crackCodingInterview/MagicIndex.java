package com.codingNinja.crackCodingInterview;

import java.util.ArrayList;

public class MagicIndex {
    public static int magicIndex(ArrayList<Integer> a, int n) {
        // Write your code here
        if (a.size() == 1 && a.get(0) == 0) {
            return 0;
        }
        int low = 0;
        int high = a.size() - 1;
        return modifiedBinarySearch(a, low, high);

    }

    private static int modifiedBinarySearch(ArrayList<Integer> a, int low, int high) {
        while (low <= high) {
            int mid = low + (high-low) / 2;

            if (mid == a.get(mid)) {
                return mid;
            }

            // Search towards left
            int newRight = Math.min(mid - 1, a.get(mid));
            if (newRight >= low && newRight < high) {
                int index = modifiedBinarySearch(a, low, newRight);
                if (index != -1) {
                    return index;
                }
            }

            // search towards right
            int newLeft = Math.max(mid + 1, a.get(mid));
            if (newLeft >= low && newLeft <= high) {
                int index = modifiedBinarySearch(a, newLeft, high);
                if (index != -1) {
                    return index;
                }
            }

            // continue binary search
            if (a.get(mid) > mid) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
