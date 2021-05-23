package com.gfg.arrays.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumber {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] str = br.readLine().trim().split(" ");
			int[] array = new int[n - 1];
			for (int i = 0; i < n - 1; i++) {
				array[i] = Integer.parseInt(str[i]);
			}

			System.out.println(missingNumber(array, n));
		}
	}

	static int missingNumber(int array[], int n) {
		// Your Code Here
		int sumOfNumber = ((n) * (n + 1)) / 2;
		int sumOfArray = 0;
		for (int i = 0; i < array.length; i++) {
			sumOfArray += array[i];
		}
		return sumOfNumber - sumOfArray;
	}
}
