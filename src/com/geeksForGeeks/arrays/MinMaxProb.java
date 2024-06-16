package com.geeksForGeeks.arrays;

import java.util.Scanner;

public class MinMaxProb {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}
			System.out.println(getMax(a, n));
			System.out.println(getMin(a, n));
		}
		sc.close();
	}

	static int getMin(int a[], int n) {
		int res = a[0];

		for (int i = 0; i < a.length; i++) {
			res = Math.min(res, a[i]);
		}
		return res;
	}

	static int getMax(int a[], int n) {
		int res = a[0];

		for (int i = 0; i < a.length; i++) {
			res = Math.max(res, a[i]);
		}
		return res;
	}
}
