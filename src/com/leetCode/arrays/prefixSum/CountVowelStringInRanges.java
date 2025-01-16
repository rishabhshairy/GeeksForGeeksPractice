package com.leetCode.arrays.prefixSum;

import java.util.HashSet;
import java.util.Set;

public class CountVowelStringInRanges {
    public static void main(String[] args) {
//        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        String[] words = {"a", "e", "i"};
//        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        int[][] queries = {{0, 2}, {0, 1}, {2, 2}};
        vowelStrings(words, queries);
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;
        int wl = words.length;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int[] result = new int[n];

        int[] prefixCount = new int[wl];
        prefixCount[0] = checkFirstLastVowel(vowels, words[0]) ? 1 : 0;

        for (int i = 1; i < wl; i++) {
            prefixCount[i] = prefixCount[i - 1] + (checkFirstLastVowel(vowels, words[i]) ? 1 : 0);
        }

//        for (int num : prefixCount) {
//            System.out.println(num);
//        }
//        System.out.println("------------------");
        for (int i = 0; i < n; i++) {
            int left = queries[i][0];
            int right = queries[i][1];


            result[i] = prefixCount[right] - (left == 0 ? 0 : prefixCount[left - 1]);
        }
//        for (int num : result) {
//            System.out.println(num);
//        }
        return result;
    }

    public static boolean checkFirstLastVowel(Set<Character> vowel, String word) {
        int n = word.length();
        char first = word.charAt(0);
        char last = word.charAt(n - 1);

        return vowel.contains(first) && vowel.contains(last);
    }
}
