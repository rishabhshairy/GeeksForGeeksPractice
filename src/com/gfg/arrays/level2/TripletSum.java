package com.gfg.arrays.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TripletSum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
		while (t-- > 0) {
			String inputLine[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(inputLine[0]);
			int X = Integer.parseInt(inputLine[1]);
			int A[] = new int[n];
			inputLine = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				A[i] = Integer.parseInt(inputLine[i]);
			}

			boolean ans = find3Numbers(A, n, X);
			System.out.println(ans ? 1 : 0);
		}
	}

	private static boolean find3Numbers(int A[], int n, int X) {
		// TODO Auto-generated method stub
		Arrays.sort(A);
		int minPtr = 0;
		int maxPtr = 0;

		for (int i = 0; i < A.length - 2; i++) {
			minPtr = i + 1;
			maxPtr = n - 1;
			while (minPtr < maxPtr) {
				int sum = A[minPtr] + A[maxPtr] + A[i];
				if (sum == X) {
					return true;
				} else if (sum < X) {
					minPtr++;
				} else {
					maxPtr--;
				}
			}

		}
		return false;
	}
}
