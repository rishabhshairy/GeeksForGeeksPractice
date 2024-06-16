package com.geeksForGeeks.arrays.level2;

import java.util.Scanner;

public class MajorityElement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			int a[] = new int[n];

			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();

			System.out.println(findMajority(a, n));

			t--;
		}
		sc.close();
	}
	
	private static int probableCandiate(int[] a, int n)
	{
		int count = 1;
		int index = 0;

		for (int i = 1; i < a.length; i++) {
			if (a[index] == a[i]) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				index = i;
				count = 1;
			}
		}
		return a[index];
	}
	
	private static int findMajority(int[] a, int size) {
		// TODO Auto-generated method stub
		
		if (size == 1) {
			return a[0];
		}
		
		if (size == 2) {
			return -1;
		}

		int probableElement = probableCandiate(a, size);
		int elemCount = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == probableElement) {
				elemCount++;
			}
			if (elemCount > size / 2) {
				return probableElement;
			}
		}

		return -1;
	}

}
