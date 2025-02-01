package com.leetCode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat fish";
        WordPattern obj = new WordPattern();
        obj.wordPattern(pattern, s);
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, Integer> patternMap = new HashMap<>();
        Map<String, Integer> sMap = new HashMap<>();

        String[] split = s.split(" ");

        if (pattern.length() < split.length) {
            return false;
        }
        for (Character ch : pattern.toCharArray()) {
            patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
        }
        for (String ss : split) {
            sMap.put(ss, sMap.getOrDefault(ss, 0) + 1);
        }

        return patternMap.size() == sMap.size();
    }
}
