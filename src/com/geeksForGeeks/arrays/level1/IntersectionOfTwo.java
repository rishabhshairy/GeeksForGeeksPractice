package com.geeksForGeeks.arrays.level1;

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;

public class IntersectionOfTwo {
	public static void main(String[] args) {

		// Taking input using class Scanner
		Scanner sc = new Scanner(System.in);

		// Taking count of total testcases
		int t = sc.nextInt();

		while (t-- > 0) {
			int n, m;

			// taking count of elements in array a
			n = sc.nextInt();

			// taking count of elements in array b
			m = sc.nextInt();

			// Creating 2 arrays of n and m
			int a[] = new int[n];
			int b[] = new int[m];

			// inserting elements to array a
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}

			// inserting elements to array b
			for (int i = 0; i < m; i++) {
				b[i] = sc.nextInt();
			}

			// calling NumberofElementsInIntersection method
			// and printing the result
			System.out.println(NumberofElementsInIntersection(a, b, n, m));
		}
	}

	public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
		// Your code here
		Set<Integer> setA = new HashSet<Integer>();
		Set<Integer> setB = new HashSet<Integer>();

		for (int i = 0; i < b.length; i++) {
			setB.add(b[i]);
		}
		for (int i = 0; i < a.length; i++) {
			setA.add(a[i]);
		}

		setA.retainAll(setB);

		return setA.size();
	}
}
