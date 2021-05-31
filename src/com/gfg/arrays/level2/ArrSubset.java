package com.gfg.arrays.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ArrSubset {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			StringTokenizer stt = new StringTokenizer(br.readLine());

			long n = Long.parseLong(stt.nextToken());
			long m = Long.parseLong(stt.nextToken());
			long a1[] = new long[(int) (n)];
			long a2[] = new long[(int) (m)];

			String inputLine[] = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				a1[i] = Long.parseLong(inputLine[i]);
			}
			String inputLine1[] = br.readLine().trim().split(" ");
			for (int i = 0; i < m; i++) {
				a2[i] = Long.parseLong(inputLine1[i]);
			}

			System.out.println(isSubset(a1, a2, n, m));

		}
	}

	private static String isSubset(long[] a1, long[] a2, long n, long m) {
		// TODO Auto-generated method stub
		HashSet<Long> setA = new HashSet<>();

		for (int i = 0; i < a1.length; i++) {
			setA.add(a1[i]);
		}
		for (int i = 0; i < a2.length; i++) {
			if (!setA.contains(a2[i])) {
				return "No";
			}
		}
		
		return "Yes";
	}
}
