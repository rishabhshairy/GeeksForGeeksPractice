package com.gfg.arrays.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InplaceSorting {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[n];
			String inputLine[] = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(inputLine[i]);
			}

			sort012(arr, n);
			StringBuffer str = new StringBuffer();
			for (int i = 0; i < n; i++) {
				str.append(arr[i] + " ");
			}
			System.out.println(str);
		}
	}

	private static void sort012(int[] a, int n) {
		// TODO Auto-generated method stub
		int c0 = 0, c1 = 0, c2 = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				c0++;
			} else if (a[i] == 1) {
				c1++;
			} else {
				c2++;
			}
		}

		int i = 0;

		while (c0 > 0) {
			a[i++] = 0;
			c0--;
		}
		
		while (c1 > 0) {
			a[i++] = 1;
			c1--;
		}
		while (c2 > 0) {
			a[i++] = 2;
			c2--;
		}
	}
}
