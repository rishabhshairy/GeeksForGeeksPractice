package com.gfg.arrays.level2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LongestConsqSub {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			int a[] = new int[n];

			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();

			System.out.println(findLongestConseqSubseq(a, n));

			t--;
		}
		sc.close();
	}

	private static int findLongestConseqSubseq(int[] arr, int n) {
		// TODO Auto-generated method stub
		/*
		 * O(n) solution  GFG does not accept it LOL :D
		 */
		Set<Integer> commonSet = new TreeSet<Integer>();
		int ans = 0;
		for (int i : arr) {
			commonSet.add(i);
		}
		for (int i = 0; i < n; i++) {
			if (!commonSet.contains(arr[i] - 1)) {
				int firstElem = arr[i];
				while (commonSet.contains(firstElem)) {
					firstElem++;
				}
				if (ans < firstElem - arr[i]) {
					ans = firstElem - arr[i];
				}
			}

		}
		return ans;
	}
}
