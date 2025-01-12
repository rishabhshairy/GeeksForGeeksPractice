package com.leetCode.arrays.prefixSum;

public class MinOpsToMoveAllBallsToEachBox {
    public static void main(String[] args) {
        String s = "001011";
        MinOpsToMoveAllBallsToEachBox obj = new MinOpsToMoveAllBallsToEachBox();
        obj.minOperations(s);
    }

    /**
     * TODO:: Optimise this solution
     * @param s
     * @return
     */
    private int[] minOperations(String s) {
        int n = s.length();
        int[] prefixCount = new int[n];
        prefixCount[0] = s.charAt(0) == '1' ? 1 : 0;

        int[] prefixCountBack = new int[n];
        prefixCountBack[n - 1] = s.charAt(n - 1) == '1' ? 1 : 0;

        for (int i = 1; i < n; i++) {
            prefixCount[i] = prefixCount[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
        }

        for (int i = n - 2; i >= 0; i--) {
            prefixCountBack[i] = prefixCountBack[i + 1] + (s.charAt(i) == '1' ? 1 : 0);
        }

        for (int num : prefixCount) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : prefixCountBack) {
            System.out.print(num + " ");
        }

        return new int[]{};
    }

    public int[] minOperationsBruteForce(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && boxes.charAt(j) != '0') {
                    result[i] += Math.abs(i - j);
                }
            }
            System.out.println(result[i]);
        }

        return result;
    }
}
