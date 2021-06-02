package com.gfg.arrays.level2;

public class WaveArray {
	public static void main(String[] args) {
		int a[] = {7808, 6907, 8683, 8551, 9980, 9205 };
		formWave(a, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	static void formWave(int arr[], int n) {
		int i = 0;
		for (i = 0; i < n - 1; i++) {
			int j = i + 1;
			if ((i) % 2 == 0) {
				if (arr[i] >= arr[j]) {
					continue;
				} else {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			} else {
				if (arr[i] <= arr[j]) {
					continue;
				} else {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
