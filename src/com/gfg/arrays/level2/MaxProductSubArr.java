package com.gfg.arrays.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxProductSubArr {
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
			System.out.println(maxSubArrProduct(arr, n));
		}
	}

	private static long maxSubArrProduct(int[] arr, int n) {
		// TODO Auto-generated method stub
		long maxEndingHere = 1;
		long minEndingHere = 1;

		long flag = 0;
		long maxSoFar = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > 0) {
				maxEndingHere = maxEndingHere * arr[i];
				minEndingHere = Math.min(minEndingHere * arr[i], 1);
				flag = 1;

			} else if (arr[i] == 0) {
				maxEndingHere = 1;
				minEndingHere = 1;
			} else {
				long temp = maxEndingHere;
				maxEndingHere = Math.max(minEndingHere * arr[i], 1);
				minEndingHere = temp * arr[i];
			}

			// update maxSoFar
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
			}
		}

		if (flag == 0 && maxSoFar == 0) {
			return 0;
		}
		return maxSoFar;
	}
}
