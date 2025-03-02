package com.leetCode.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * This question is combination of
 */
public class LetterTilePossibilities {
    public static void main(String[] args) {
        String s = "AAB";
        LetterTilePossibilities obj = new LetterTilePossibilities();
        obj.numTilePossibilities(s);
    }

    public int numTilePossibilities(String tiles) {
        if (tiles.length() == 1) {
            return 1;
        }
        int n = tiles.length();
        Set<String> result = new HashSet<>();
        boolean[] visited = new boolean[n];
        solve("", tiles, result, visited);
        System.out.println(result);
        return result.size() - 1;
    }

    private void solve(String curr, String tiles, Set<String> result, boolean[] visited) {
        result.add(curr);
        for (int i = 0; i < tiles.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                solve(curr + tiles.charAt(i), tiles, result, visited);
                visited[i] = false;
            }
        }
    }
}
