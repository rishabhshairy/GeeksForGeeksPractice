package com.gfg.arrays.level3;

public class MinimumJumps {
    public static void main(String[] args) {
        int[] test = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(test));
    }

    static int minJumps(int[] arr) {
        // your code here
        if (arr.length <= 1) {
            return 0;
        }

        if(arr[0]==0){
            return -1;
        }

        int max = arr[0];
        int remainingSteps = arr[0];
        int jump = 1;

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) {
                return jump;
            }

            max = Math.max(max, i + arr[i]);
            remainingSteps--;

            if (remainingSteps == 0) {
                jump++;

                if (i >= max) {
                    return -1;
                }

                remainingSteps = max - i;
            }
        }

        return -1;

    }
}
