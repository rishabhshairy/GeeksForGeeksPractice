package com.geeksForGeeks.arrays.level2;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {
	public static void main(String[] args) {

	}

	static int firstNonRep(int[] arr, int n) {
		Map<Integer, Integer> repMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (repMap.containsKey(arr[i])) {
				repMap.put(arr[i], repMap.get(arr[i]) + 1);
			}
			repMap.put(arr[i], 1);
		}

		for (int i = 0; i < arr.length; i++) {
			if (repMap.get(arr[i]) == 1) {
				return repMap.get(arr[i]);
			}
		}

		return -1;
	}
}
