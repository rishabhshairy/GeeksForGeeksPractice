package com.gfg.arrays.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TwoRepElem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String l = br.readLine();
			String[] sarr = l.split(" ");
			int[] arr = new int[sarr.length];
			for (int i1 = 0; i1 < arr.length; i1++) {
				arr[i1] = Integer.parseInt(sarr[i1]);
			}

			Pair res = twoRepeated(arr, n);
			System.out.println(res.first + " " + res.second);

		}
	}

	private static Pair twoRepeated(int[] arr, int N) {
		// This Solution is O(n) both time and space

		Map<Integer, Integer> compMap = new HashMap<>();
		Pair ans = new Pair();
		int first = 0;
		int second = 0;

		for (int i = 0; i < arr.length; i++) {
			if (compMap.containsKey(arr[i])) {
				compMap.put(arr[i], i);
			} else {
				compMap.put(arr[i], -1);
			}
		}

		for (Integer key : compMap.keySet()) {
			if (compMap.get(key) >= 0) {
				if (first == 0) {
					first = compMap.get(key);
				} else {
					second = compMap.get(key);
					break;
				}
			}
		}
		ans.first = arr[Math.min(first, second)];
		ans.second = arr[Math.max(first, second)];
		return ans;

		/*
		 * This solution is for O(n) --> Time and O(1)--> Space
		 * boolean first = false; Pair res = new Pair();
		 * 
		 * for(int p = 0; p < N+2 ; p++) { if(arr[Math.abs(arr[p])] > 0) {
		 * arr[Math.abs(arr[p])] = -arr[Math.abs(arr[p])]; } else { if(first==false) {
		 * res.first = Math.abs(arr[p]); first = true; } else res.second =
		 * Math.abs(arr[p]);
		 * 
		 * } } return res;
		 */
	}

}

class Pair {
	public int first;
	public int second;
}