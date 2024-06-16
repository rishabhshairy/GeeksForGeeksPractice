package com.leetCode.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak {
    static HashMap<String, Boolean> wordMap = new HashMap<>();

    public static void main(String[] args) {
        String s = "leetcode";
        ArrayList<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        wordBreak(s, list);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        if (wordMap.containsKey(s) && !wordMap.get(s)) {
            return false;
        }

        for (String word :
                wordDict) {
            int len = word.length();
            if (s.indexOf(word) == 0) {
                if (wordBreak(s.substring(len), wordDict)) {
                    return true;
                }
            }
        }
        wordMap.put(s, false);
        return false;
    }
}
