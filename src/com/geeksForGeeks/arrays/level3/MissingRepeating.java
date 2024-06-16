package com.geeksForGeeks.arrays.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class MissingRepeating {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] str = br.readLine().split(" ");

			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(str[i]);
			}

			int[] ans = findTwoElement(a, n);
			System.out.println(ans[0] + " " + ans[1]);
		}
	}

	static int[] findTwoElement(int arr[], int n) {
		/*
		 * This solution is O(n) both space and time
		 */
		int[] twoElem = new int[2];
		HashSet<Integer> hs = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {

			if (hs.contains(arr[i])) {
				twoElem[0] = arr[i];
			} else {
				hs.add(arr[i]);
			}
		}

		for (int i = 1; i < n + 1; i++) {
			if (!hs.contains(i)) {
				twoElem[1] = i;
				break;
			}
		}

		return twoElem;
	}

	static int[] fintTwoOptimal(int arr[], int n) {

		int[] twoElem = new int[2];
		// Repeating
		for (int i = 0; i < arr.length; i++) {
			int absVal = Math.abs(arr[i]);
			if (arr[absVal - 1] > 0) {
				arr[absVal - 1] = -arr[absVal - 1];
			} else {
				twoElem[0] = absVal;
			}
		}
		// Missing
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				twoElem[1] = i + 1;
			}
		}
		return twoElem;
	}
}
