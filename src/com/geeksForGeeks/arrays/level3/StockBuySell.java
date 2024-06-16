package com.geeksForGeeks.arrays.level3;

import java.io.IOException;

public class StockBuySell {
	public static void main(String[] args) throws NumberFormatException, IOException {

		int[] arr = { 100, 180, 260, 310, 40, 535, 695 };
		stockBuySell(arr, arr.length);
	}

	private static void stockBuySell(int[] A, int n) {
		// TODO Auto-generated method stub

		int minElem = A[0];
		int cost = 0;
		int maxCost = 0;

		for (int i = 0; i < A.length; i++) {
			minElem = Math.min(minElem, A[i]);

			cost = A[i] - minElem;
			maxCost = Math.max(maxCost, cost);
		}
		System.out.println("max profit is " + maxCost);

	}
}
