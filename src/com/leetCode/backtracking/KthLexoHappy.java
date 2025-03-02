package com.leetCode.backtracking;

import java.util.PriorityQueue;

/**
 * LC 1415
 */
public class KthLexoHappy {
    public static void main(String[] args) {
        int n = 1;
        int k = 4;
        KthLexoHappy obj = new KthLexoHappy();
        obj.getHappyString(n, k);
    }

    public String getHappyString(int n, int k) {
        char[] allowedChar = {'a', 'b', 'c'};
        PriorityQueue<String> maxHeap = new PriorityQueue<>();
        solve(n, new StringBuilder(), maxHeap, allowedChar);

        if (maxHeap.size() < k) {
            return "";
        }

        String res = "";
        while (!maxHeap.isEmpty() && k-- > 0) {
            res = maxHeap.poll();
        }

        return res;
    }

    private void solve(int n, StringBuilder curr, PriorityQueue<String> maxHeap, char[] allowedChar) {
        if (curr.length() == n) {
            maxHeap.add(curr.toString());
            return;
        }
        for (int i = 0; i < allowedChar.length; i++) {
            // skip if last char is same
            if (curr.length() > 0 && allowedChar[i] == curr.charAt(curr.length() - 1)) {
                continue;
            }
            curr.append(allowedChar[i]);
            solve(n, curr, maxHeap, allowedChar);
            curr.setLength(curr.length() - 1);
        }
    }
}
