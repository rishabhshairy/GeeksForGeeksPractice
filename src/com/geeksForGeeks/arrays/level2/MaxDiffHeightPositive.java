package com.geeksForGeeks.arrays.level2;

import java.util.Arrays;
import java.util.Scanner;

public class MaxDiffHeightPositive {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// taking total number of testcases
		int t = scan.nextInt();
		while (t-- > 0) {
			// input k
			int k = scan.nextInt();
			// taking total count of elements
			int n = scan.nextInt();
			// Declaring and Initializing an array of size n
			int arr[] = new int[n];
			// adding elements to the array
			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextInt();
			}

			System.out.println(getMaxDiff(arr, n, k));
		}
		scan.close();
	}

	static int getMaxDiff(int arr[], int n, int k) {
		Arrays.sort(arr);
		int result = arr[n - 1] - arr[0];
		int max = arr[n - 1];
		int min = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i]>=k) {
				max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
				min = Math.min(arr[0] + k, arr[i] - k);

				result = Math.min(result, max - min);
			} else {
				continue;
			}


		}
		return result;
	}
}
