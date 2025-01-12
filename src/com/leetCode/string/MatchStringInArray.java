package com.leetCode.string;

import java.util.*;

public class MatchStringInArray {
    public List<String> stringMatching(String[] words) {

        Set<String> uniqueWords = new LinkedHashSet<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[i].contains(words[j])) {
                    uniqueWords.add(words[j]);
                }
            }
        }
        return uniqueWords.isEmpty() ? new ArrayList<>() : new ArrayList<>(uniqueWords);
    }
}
