package com.arrays.gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Duplicates {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();

			}
			ArrayList<Integer> arr = duplicates(a, n);
			for (Integer integer : arr) {
				System.out.print(integer + " ");
			}
//			System.out.println();
			sc.close();
		}

	}

	public static ArrayList<Integer> duplicates(int arr[], int n) {
		// code here
		ArrayList<Integer> answerList = new ArrayList<>();

		int i = 0;
		boolean haveDuplicates = false;
		Arrays.sort(arr);

		if (arr.length <= 1) {
			answerList.add(-1);
			return answerList;
		}

		for (int j = i + 1; j < arr.length; j++) {

			if (arr[i] == arr[j]) {
				haveDuplicates = true;
				if (!(answerList.contains(arr[i]))) {
					answerList.add(arr[i]);
				}
			} else {
				i = j;
			}
		}

		if (!haveDuplicates) {
			answerList.add(-1);
		}
		return answerList;
	}
}
