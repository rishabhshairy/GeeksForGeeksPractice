package com.binaySearchConcepts;

/**
 * https://www.naukri.com/code360/problems/minimise-max-distance_7541449
 * LC Premium
 */
public class MinimizeMaxGasDistance {
    public static void main(String[] args) {
//        int[] arr = {1, 13, 17, 23};
//        int k = 5;
        int[] arr = {1,2,3,4,5,6,7};
        int k = 6;
        double maxDistance = MinimiseMaxDistance(arr, k);
        System.out.println(maxDistance);
    }

    /**
     * This is brute force approach
     * @param arr
     * @param k
     * @return
     */
    public static double MinimiseMaxDistance(int[] arr, int k) {
        // Write your code here.
        int[] howManyPlaced = new int[arr.length - 1];
        for (int gas = 1; gas <= k; gas++) {
            double maxValBetweenStation = -1;
            int maxIndex = -1;

            for (int i = 0; i < arr.length - 1; i++) {
                double diffBetweenStation = arr[i + 1] - arr[i];
                double sectionLength = diffBetweenStation / (double) (howManyPlaced[i] + 1);

                if (maxValBetweenStation < sectionLength) {
                    maxValBetweenStation = sectionLength;
                    maxIndex = i;
                }
//                System.out.println(maxValBetweenStation);
//                System.out.println(maxIndex);
            }
            howManyPlaced[maxIndex]++;
//            System.out.println("Placed = " + howManyPlaced[maxIndex] + " at index " + maxIndex);
        }
        double maxAns = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            double sectorLength = (arr[i + 1] - arr[i]) / (double)(howManyPlaced[i] + 1);
            maxAns = Math.max(maxAns, sectorLength);
        }
        return maxAns;
    }
}
