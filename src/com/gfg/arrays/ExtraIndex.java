package com.gfg.arrays;

import java.util.Scanner;

public class ExtraIndex {

	// { Driver Code Starts

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[n - 1];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			for (int i = 0; i < n - 1; i++)
				b[i] = sc.nextInt();

			System.out.println(findExtra(a, b, n));
		}
	}

	public static int findExtra(int a[], int b[], int n) {
		if (a[0] != b[0])
			return 0;
		if (a[n - 1] != b[n - 2])
			return n - 1;

		int low = 0, high = n - 2;

		while (low < high) {
			int mid = (low + high) / 2;

			if (a[mid] == b[mid])
				low = mid + 1;
			else
				high = mid;
		}

		return low;
	}
}
