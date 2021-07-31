package com.leetcode.array_string_stack;

public class KthGrammarSymbol {
    public static void main(String[] args) {
        int n = 2, k = 2;
        System.out.println(kthGrammar(n, k));
    }

    static int kthGrammar(int n, int k) {
        int mid = (int) (Math.pow(2, n - 1) / 2);
        if (n == 1 && k == 1) {
            return 0;
        }

        if (k <= mid) {
            return kthGrammar(n - 1, k);
        } else {
            return kthGrammar(n, k-mid) ^ 1;
        }
    }
}
