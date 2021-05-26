package com.gfg.arrays.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MoreThanNK {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int a[] = new int[n];

			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			
			System.out.println(findCount(a, n, k));

			t--;
		}
		sc.close();
	}

	static int findCount(int arr[], int n, int k) {
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (countMap.containsKey(arr[i])) {
				countMap.put(arr[i], countMap.get(arr[i]) + 1);
			} else {
				countMap.put(arr[i], 1);
			}
		}
		
		for(Integer key: countMap.keySet()) {
			if (countMap.get(key) > (n/k)) {
				count++;
			}
		}
		return count;
	}
}
