package com.geeksForGeeks.arrays.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class FirstRepeating {
	public static void main(String[] args) {
		// Taking input using class Scanner
		Scanner sc = new Scanner(System.in);

		// Taking total count of testcases
		int t = sc.nextInt();

		while (t-- > 0) {
			// taking total count of elements
			int n = sc.nextInt();

			// creating a new array of size n
			int arr[] = new int[n];

			// inserting elements to the array
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			// calling firstRepeated method
			// and printing the result
			System.out.println(firstRepeated(arr, n));
		}

	}

	/*
	 * This is done by hashing Time Complexity O(n)
	 */
	public static int firstRepeatedMap(int[] arr, int n) {
		// Your code here
		HashMap<Integer, Integer> repeatMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (!repeatMap.containsKey(arr[i])) {
				repeatMap.put(arr[i], 1);
			} else {
				repeatMap.put(arr[i], repeatMap.get(arr[i]) + 1);

			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (repeatMap.get(arr[i]) > 1) {
				return i + 1;
			}
		}
		return -1;
	}

	/*
	 * 
	 */

	public static int firstRepeated(int[] arr, int n) {
		// Your code here
		int[] temp = new int[n];

		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		Arrays.sort(temp);

		for (int i = 0; i < arr.length; i++) {

			int l = 0;
			int r = n - 1;
			int count = 1;
		
			int index = i;
			
			while (l <= r) {
				int m = (l + r) / 2;
				if (temp[m] == arr[i]) {
					index = m;
				}

				if (arr[i] < temp[m]) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			}
			
			int min = -1;
			System.out.println("index val -->" + index);
			int leftOcc = index -1;
			while(leftOcc >=0 && temp[leftOcc]==arr[i])
			{
				count++;
				leftOcc--;
			}
			
			int rightOcc=index+1;
			while (rightOcc < n && temp[rightOcc]==arr[i]) {
				count++;
				rightOcc++;
			}
			System.out.println("count -->" + count);
			if (count > 1) {
				return i+1;
			}
		}
		return -1;
	}

}
