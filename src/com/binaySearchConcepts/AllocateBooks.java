package com.binaySearchConcepts;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooks {
    public static void main(String[] args) {

    }

    public static int findPages(ArrayList<Integer> books, int n, int students) {
        if (students > n) {
            return -1;
        }
        int totalPages = 0;
        int maxPageInBook = Integer.MIN_VALUE;

        for (int i = 0; i < books.size(); i++) {
            totalPages += books.get(i);
            maxPageInBook = Math.max(maxPageInBook, books.get(i));
        }

        // now do linear search
        int low = maxPageInBook;
        int high = totalPages;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossibleToAllocate(books, mid) > students) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // returning low as the high will be in opposite polarity
        return low;
    }

    public static int findPagesBruteForce(ArrayList<Integer> books, int n, int students) {
        // Write your code here.
        if (students > n) {
            return -1;
        }
        int totalPages = 0;
        int maxPageInBook = Integer.MIN_VALUE;

        for (int i = 0; i < books.size(); i++) {
            totalPages += books.get(i);
            maxPageInBook = Math.max(maxPageInBook, books.get(i));
        }

        // now do linear search
        int lowestPage = maxPageInBook;
        int maxPage = totalPages;

        for (int pages = lowestPage; pages <= maxPage; pages++) {

            if (isPossibleToAllocate(books, pages) == students) {
                return pages;
            }
        }
        return -1;

    }

    private static int isPossibleToAllocate(ArrayList<Integer> books, int pages) {
        int currStudent = 1;
        int currPageSum = 0;

        for (Integer pageCount :
                books) {
            if (currPageSum + pageCount <= pages) {
                currPageSum += pageCount;
            } else {
                currStudent++;
                currPageSum = pageCount;
            }
        }
        return currStudent;
    }
}
