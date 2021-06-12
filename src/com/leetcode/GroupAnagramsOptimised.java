package com.leetcode;

import java.util.*;

public class GroupAnagramsOptimised {
    public static void main(String[] args) {
        String[] anagrams = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //String[] anagrams = {"a"};

        for (List<String> s :
                groupAnagrams(anagrams)) {
            System.out.println(s);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String temp = Arrays.toString(c);
            if (!map.containsKey(temp)) {
                map.put(temp, new LinkedList<>());
            }
            map.get(temp).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
