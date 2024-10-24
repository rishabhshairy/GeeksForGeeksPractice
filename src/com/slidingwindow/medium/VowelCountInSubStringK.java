package com.slidingwindow.medium;

import java.util.List;

public class VowelCountInSubStringK {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(maxVowels(s, 3));
    }

    /**
     * Brute Force
     * Optimal
     *
     * @param s
     * @param k
     * @return
     */
    public static int maxVowels(String s, int k) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        int maxCount = 0;

        int right = 0, count = 0;

        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }
        maxCount = count;
        right = k;
        while (right < s.length()) {
            // reducing vowel count from left;
            if (vowels.contains(s.charAt(right - k))) {
                count--;

            }

            // increase current vowel count if found
            if (vowels.contains(s.charAt(right))) {
                count++;
            }
            right++;
            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }

    // below solution is brute force
/*        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (int j = i; j < s.length(); j++) {
                if (Math.abs(j - i + 1) == k) {
                    for (Character ch :
                            s.substring(i, j + 1).toCharArray()) {
                        if (vowels.contains(ch)) {
                            count++;
                        }
                    }
                }
                maxCount = Math.max(count, maxCount);
            }

        }*/
}
