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

	private static int maxSubArrProduct(int[] arr, int n) {
		// TODO Auto-generated method stub
		int maxSoFar = Integer.MIN_VALUE;
		int maxEnd = arr[0];

		for (int i : arr) {
			if (i == 0 || maxEnd == 0) {
				continue;
			}
			maxEnd = maxEnd * i;
			System.out.println("max end val -->" + maxEnd);
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
