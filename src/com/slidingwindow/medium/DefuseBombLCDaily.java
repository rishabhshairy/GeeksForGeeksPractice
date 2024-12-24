package com.slidingwindow.medium;

public class DefuseBombLCDaily {
    public static void main(String[] args) {
        int[] arr = {5,7,1,4};
        decrypt(arr,3);
    }

    /**
     * Using concept of prefix sum cache
     *
     * @param code
     * @param k
     * @return
     */
    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            return new int[n];
        }

        int[] prefixSumCache = new int[(2 * n) + 1];

        for (int i = 0; i < 2 * n; i++) {
            prefixSumCache[i + 1] = prefixSumCache[i] + code[i % n];
//            System.out.println(prefixSumCache[i + 1]);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {

            int end = i + k;
            if (k < 0) {
                // range for negative will be (i-k,i-1)
                res[i] = prefixSumCache[i + n] - prefixSumCache[end + n];
            } else {
                // range for positive will be (i+1,i+k)
                res[i] = prefixSumCache[end + 1] - prefixSumCache[i + 1];
            }
//            System.out.print(res[i]+" ");
        }
        return res;
    }
}
