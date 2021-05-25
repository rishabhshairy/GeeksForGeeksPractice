package com.gfg.arrays.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CommonInThreeSorted {
	public static void main(String[] args) {
		// taking input using Scanner class
		Scanner sc = new Scanner(System.in);

		// taking total count of testcases
		int t = sc.nextInt();
		while (t-- > 0) {
			// taking total count-1 of elements
			int n = sc.nextInt();

			// Declaring and Initializing an ArrayList-1
			ArrayList<Integer> v1 = new ArrayList<>();

			// adding elements to the ArrayList-1
			for (int i = 0; i < n; i++) {
				v1.add(sc.nextInt());
			}

			// taking total count-2 of elements
			int m = sc.nextInt();

			// Declaring and Initializing an ArrayList-2
			ArrayList<Integer> v2 = new ArrayList<>();

			// adding elements to the ArrayList-2
			for (int i = 0; i < m; i++) {
				v2.add(sc.nextInt());
			}

			// calling the method common_element
			// and passing ArrayList 1, 2 as arguments
			// and storing the results in a new ArrayList
			ArrayList<Integer> ans = common_element(v1, v2);

			// printing the elements of the new ArrayList
			for (int i : ans)
				System.out.print(i + " ");

			System.out.println();
		}
	}

	public static ArrayList<Integer> common_element(ArrayList<Integer> v1, ArrayList<Integer> v2) {
		// Your code here
		ArrayList<Integer> commonList = new ArrayList<Integer>();
		Collections.sort(v1);
		Collections.sort(v2);

		for (int i = 0, j = 0; i < v1.size() && j < v2.size();) {
			int a = v1.get(i);
			int b = v2.get(j);
			if (a == b) {
				commonList.add(a);
				i++;
				j++;
			} else if (a < b) {
				i++;
			} else {
				j++;
			}
		}
		return commonList;
	}
}
