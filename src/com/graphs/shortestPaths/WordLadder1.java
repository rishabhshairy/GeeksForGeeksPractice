package com.graphs.shortestPaths;

import java.util.*;

/**
 * Very Hard
 * VVIMP
 */
public class WordLadder1 {
    public static void main(String[] args) {
        String start = "der";
        String end = "dfs";
        String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};
        int count = wordLadderLength(start, end, wordList);
        System.out.println(count);
    }

    static class Word {
        String word;
        int level;

        public Word(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    /**
     * BFS Solution
     *
     * @param startWord
     * @param targetWord
     * @param wordList
     * @return
     */
    public static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));
        // remove start word from set if available to avoid cycles
        wordSet.remove(startWord);

        Queue<Word> wordQueue = new LinkedList<>();
        wordQueue.offer(new Word(startWord, 1));

        while (!wordQueue.isEmpty()) {
            Word currWord = wordQueue.poll();
            String word = currWord.word;
            int level = currWord.level;

            if (word.equals(targetWord)) {
                return level;
            }

            // TC --> wordLength * 26 * N
            // SC -->
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacement = word.toCharArray();
                    replacement[i] = ch;
                    String replacedWord = String.valueOf(replacement);
                    if (wordSet.contains(replacedWord)) {
                        wordSet.remove(replacedWord);
                        wordQueue.offer(new Word(replacedWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
