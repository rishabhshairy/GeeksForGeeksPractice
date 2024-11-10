package com.leetCode.string;

import java.util.ArrayList;
import java.util.List;

public class MinChangesBinaryStringBeautiful {
    public static void main(String[] args) {
        MinChangesBinaryStringBeautiful obj = new MinChangesBinaryStringBeautiful();
        int i = obj.minChangesOptimal("10");
        System.out.println(i);
    }


    public int minChangesOptimal(String s) {
        int minCount = 0;
        for (int i = 1; i < s.length(); i += 2) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                minCount++;
            }
        }
        return minCount;
    }

    /**
     * TC --> O(n)
     * SC --> O(n)
     *
     * @param s
     * @return
     */
    public int minChanges(String s) {
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < s.length(); i += 2) {
            stringList.add(s.substring(i, i + 2));
        }

        int minCount = 0;
        for (String str : stringList) {
            if (str.charAt(0) != str.charAt(1)) {
                minCount++;
            }
        }
        return minCount;
    }
}
