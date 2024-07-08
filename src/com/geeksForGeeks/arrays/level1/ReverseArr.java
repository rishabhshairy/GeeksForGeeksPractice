package com.geeksForGeeks.arrays.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseArr {

	public static void main(String args[]) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {
			String str = read.readLine();
			System.out.println(reverseWord(str));
		}
	}

	static String reverseWord(String s) {
		int l = 0;
		int r = s.length() - 1;
		char[] res = s.toCharArray();
		String ans = "";
		for (int i = 0; i < res.length / 2; i++) {
			if (res[l] == res[r]) {
				l++;
				r--;
			} else {
				char swapChar = res[l];
				res[l] = res[r];
				res[r] = swapChar;
				l++;
				r--;
			}
		}
		for (int i = 0; i < res.length; i++) {
			ans += res[i];
		}

		return ans;
	}
}
