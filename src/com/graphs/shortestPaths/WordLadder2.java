package com.graphs.shortestPaths;

import java.util.*;

/**
 * GFG
 * Very Hard
 */
public class WordLadder2 {

    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};
        System.out.println(findSequences(startWord, targetWord, wordList));
    }

    public static ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        // Code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));
        // define a queue of List of Sequence
        Queue<ArrayList<String>> sequence = new LinkedList<>();
        // Define one list with starting word
        ArrayList<String> currWords = new ArrayList<>();
        currWords.add(startWord);
        sequence.offer(currWords);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;

        while (!sequence.isEmpty()) {
            ArrayList<String> currList = sequence.poll();

            // Check if we are on new level and remove all words from set which is
            // being stored in usedOnLevel list

            if (currList.size() > level) {
                level++;
                for (String str : usedOnLevel) {
                    wordSet.remove(str);
                }
            }

            // now get the word from end of currList and start operating
            String word = currList.get(currList.size() - 1);

            // if word is found
            if (word.equals(targetWord)) {
                if (result.size() == 0) {
                    result.add(currList);
                } else if (result.get(0).size() == currList.size()) {
                    // this means we already have a transformed list
                    result.add(currList);
                }
            }

            // now change the character of word and check
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacement = word.toCharArray();
                    replacement[i] = ch;
                    String replacedWord = String.valueOf(replacement);
                    if (wordSet.contains(replacedWord)) {
                        currList.add(replacedWord);

                        ArrayList<String> listForQueue = new ArrayList<>(currList);
                        sequence.offer(listForQueue);

                        // mark current word as visited
                        usedOnLevel.add(replacedWord);
                        // remove from curr operating list to add new transformed words
                        currList.remove(currList.size() - 1);
                    }
                }
            }
        }
        return result;
    }
}
