package com.geeksForGeeks.arrays.level1;

import java.util.HashMap;
import java.util.Scanner;

public class NumberFrequency {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}
			int k = sc.nextInt();
			System.out.println(countFreq(a, k));
		}
		sc.close();
	}

	static int countFreq(int arr[], int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		return map.get(k);
	}
}
