package com.gfg.arrays.level2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class BigFactorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int N = sc.nextInt();

			ArrayList<Integer> ans = factorial(N);
			for (Integer val : ans)
				System.out.print(val);
			System.out.println();
		}
		sc.close();
	}

	private static ArrayList<Integer> factorial(int n) {
		// TODO Auto-generated method stub
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		BigInteger fact = BigInteger.ONE;
		
		while(n>1)
		{	
			long ns = (long)n;
			fact = fact.multiply(BigInteger.valueOf(ns));
			n--;
		}
		String factorial = fact.toString();
		for (int i = 0; i < factorial.length(); i++) {
			answerList.add(Integer.parseInt(String.valueOf(factorial.charAt(i))));
		}
		return answerList;
	}
}
