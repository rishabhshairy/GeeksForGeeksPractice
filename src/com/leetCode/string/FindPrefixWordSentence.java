package com.leetCode.string;

/**
 * LC 1455
 * Daily Q 2.12.24
 */
public class FindPrefixWordSentence {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");

        for (int i = 0; i < arr.length; i++) {

            if (arr[i].indexOf(searchWord) == 0) {
                return i;
            }
        }
        return -1;
    }
}
