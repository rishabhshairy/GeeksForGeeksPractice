package com.gfg.arrays.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CyclicRotation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
		while (t-- > 0) {
			long n = Long.parseLong(br.readLine().trim());
			long a[] = new long[(int) (n)];
			// long getAnswer[] = new long[(int)(n)];
			String inputLine[] = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				a[i] = Long.parseLong(inputLine[i]);
			}

			rotate(a, n);

			StringBuilder output = new StringBuilder();
			for (int i = 0; i < n; i++) {
				output.append(a[i] + " ");
			}
			System.out.println(output);
		}

	}

	static void rotate(long arr[], long n) {
		long temp = arr[(int) (n - 1)];
		for (int i = (int) n; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;
	}
}
