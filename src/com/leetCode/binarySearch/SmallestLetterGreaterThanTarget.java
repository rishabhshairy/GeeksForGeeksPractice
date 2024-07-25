package com.leetCode.binarySearch;

public class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] arr = {'c', 'f', 'j'};
        char target = 'z';
        System.out.println(nextGreatestLetter(arr, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (letters[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return letters[ans];
    }
}
