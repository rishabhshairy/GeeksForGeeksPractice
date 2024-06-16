package com.interviewBit.java.bigints;

import java.math.BigInteger;
import java.util.Scanner;

public class BigSumEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        BigInteger a1 = new BigInteger(a);
        BigInteger b1 = new BigInteger(b);

        System.out.println(a1.add(b1));
    }
}
