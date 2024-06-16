package com.geeksForGeeks.arrays.level2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SubArrZeroSum {
	public static void main(String[] args) {
		// taking input using class Scanner
		Scanner scan = new Scanner(System.in);

		// taking total number of testcases
		int t = scan.nextInt();
		while (t > 0) {
			// taking total count of elements
			int n = scan.nextInt();

			// Declaring and Initializing an array of size n
			int arr[] = new int[n];

			// adding elements to the array
			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextInt();
			}

			t--;

			// calling the method findSum
			// and print "YES" or "NO" based on the result
			System.out.println(findsum(arr, n) == true ? "Yes" : "No");
		}
	}

	static boolean findsum(int arr[], int n) {
		// Your code here
		Set<Integer> sumSet = new HashSet<Integer>();

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {

			sum += arr[i];

			if (arr[i] == 0 || (sumSet.contains(sum) && sum == 0)) {
				return true;
			}
			sumSet.add(sum);
		}

		return false;
	}
}
