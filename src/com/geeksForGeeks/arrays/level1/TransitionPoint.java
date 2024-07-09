package com.geeksForGeeks.arrays.level1;

import java.util.Scanner;

public class TransitionPoint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();

			}
			int arr = transitionPoint(a, n);
			System.out.print(arr);
//			System.out.println();
			sc.close();
		}

	}

	static int transitionPoint(int arr[], int n) {
		// code here
		int r = n - 1;

		int l = 0;

		if (arr[l] == 1 && arr[r] == 1) {
			return 0;
		}

		while (l <= r) {
			int m = (l + r) / 2;

			if (arr[m] == 0) {
				l = m + 1;
			} else if (arr[m] == 1) {
				if (m == 0 || (m > 0 && arr[m - 1] == 0)) {
					return m;
				}
				r = m - 1;
			}

		}
		return -1;

	}
}
