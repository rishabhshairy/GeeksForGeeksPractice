package com.leetCode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "aba";
        String s = "dog cat cat";
        WordPattern obj = new WordPattern();
        obj.wordPattern(pattern, s);
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (!charToWord.containsKey(ch)) {
                charToWord.put(ch, word);
            }
            if (!wordToChar.containsKey(word)) {
                wordToChar.put(word, ch);
            }
            // match if both map have same char word mapping
            if (!(charToWord.get(ch).equals(word)) || !(wordToChar.get(word).equals(ch))){
                return false;
            }
        }

        return true;
    }
}
