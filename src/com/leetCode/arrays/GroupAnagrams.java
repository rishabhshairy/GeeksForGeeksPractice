package com.leetCode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        //String[] anagrams = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] anagrams = {"a"};

        for (List<String> s :
                groupAnagrams(anagrams)) {
            System.out.println(s);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> group = new ArrayList<>();
        HashSet<String> anaSet = new HashSet<>();

        if (strs.length == 1) {
            List<String> groupList = new ArrayList<>();
            groupList.add(strs[0]);
            group.add(groupList);
            return group;
        }

        for (String s :
                strs) {
            char[] sortedWord = s.toCharArray();
            Arrays.sort(sortedWord);
            anaSet.add(new String(sortedWord));
        }
        int totalGroups = anaSet.size();
        for (String match : anaSet) {
            List<String> groupList = new ArrayList<>();
            for (String anagram :
                    strs) {
                char[] sortedWord = anagram.toCharArray();
                Arrays.sort(sortedWord);
                String s = new String(sortedWord);
                if (match.equals(s)) {
                    groupList.add(anagram);
                }
            }
            group.add(groupList);
        }
        return group;
    }
}
