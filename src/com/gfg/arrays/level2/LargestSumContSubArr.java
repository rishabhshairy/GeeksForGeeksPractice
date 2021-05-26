package com.gfg.arrays.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestSumContSubArr {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
		while (t-- > 0) {
			// size of array
			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[n];
			String inputLine[] = br.readLine().trim().split(" ");

			// adding elements
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(inputLine[i]);
			}

			// calling maxSubarraySum() function
			System.out.println(maxSubarraySum(arr, n));
		}
	}

	static int maxSubarraySum(int arr[], int n) {
		int maxSoFar = Integer.MIN_VALUE;
		int maxEnd = 0;

		for (int i : arr) {
			maxEnd += i;

			if (maxSoFar < maxEnd) {
				maxSoFar = maxEnd;
			}
			if (maxEnd < 0) {
				maxEnd = 0;
			}
		}
		return maxSoFar;
	}
}
