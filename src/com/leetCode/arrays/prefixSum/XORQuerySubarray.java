package com.leetCode.arrays.prefixSum;

/**
 * LC 1310
 */
public class XORQuerySubarray {

    public static void main(String[] args) {
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        int[] nums = {1, 3, 4, 8};
        XORQuerySubarray obj = new XORQuerySubarray();
        obj.xorQueries(nums, queries);
    }

    /**
     * Brute Force, go through all subquery and do XOR
     * <p>
     * Optimal Apporach
     * Store XOR of elements in a prefix array
     * and then iterate through query
     * prefix[end]^prefix[start]
     *
     * @param arr
     * @param queries
     * @return
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n+1];

        int[] prefixXor = new int[arr.length];
        prefixXor[0] = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixXor[i + 1] = prefixXor[i] ^ arr[i];

        }

        // now go through the query
        for (int i = 0; i < n; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            result[i] = prefixXor[end + 1] ^ prefixXor[start];
        }

        return result;
    }
}
