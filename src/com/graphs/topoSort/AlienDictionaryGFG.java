package com.graphs.topoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LC Premium
 * GFG
 * https://www.geeksforgeeks.org/problems/alien-dictionary/1
 */
public class AlienDictionaryGFG {
    public static void main(String[] args) {
        String[] dict = {"dhhid", "dahi", "cedg", "fg", "gdah", "i", "gbdei", "hbgf", "e", "ddde"};
        new AlienDictionaryGFG().findOrder(dict, dict.length, 9);
    }

    public String findOrder(String[] dict, int n, int k) {
        /**
         * Here K will act as number of nodes
         */

        List<List<Integer>> adjacenecyList = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            adjacenecyList.add(new ArrayList<>());
        }

        // VVIMP part constructing the graph

        for (int i = 0; i < n - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];

            int minLen = Math.min(s1.length(), s2.length());

            for (int ptr = 0; ptr < minLen; ptr++) {
                int u = s1.charAt(ptr);
                int v = s2.charAt(ptr);
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    // it means there is an edge between
                    // u --> v
                    adjacenecyList.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> sortedChars = topoSort(k, adjacenecyList);
        String result = "";
        if (sortedChars.size()!=k){
            return "";
        }
        for (Integer ch :
                sortedChars) {
            result = result + (char) (ch + (int) ('a'));
        }
//        System.out.println(result);
        return result;
    }

    private List<Integer> topoSort(int k, List<List<Integer>> adjacenecyList) {
        List<Integer> sortedChars = new ArrayList<>();
        int[] inDegrees = new int[k];
        // finding in-degrees
        for (int i = 0; i < k; i++) {
            for (Integer adjNode : adjacenecyList.get(i)) {
                inDegrees[adjNode]++;
            }
        }

        // push all 0 in-degrees to queue
        Queue<Integer> charsQueue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (inDegrees[i] == 0) {
                charsQueue.offer(i);
            }
        }

        while (!charsQueue.isEmpty()) {
            Integer currChar = charsQueue.poll();
            sortedChars.add(currChar);

            for (Integer adjChar : adjacenecyList.get(currChar)) {
                inDegrees[adjChar]--;
                if (inDegrees[adjChar] == 0) {
                    charsQueue.offer(adjChar);
                }
            }
        }
        return sortedChars;
    }
}
