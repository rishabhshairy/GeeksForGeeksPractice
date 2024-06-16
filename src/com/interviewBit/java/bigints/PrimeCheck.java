package com.interviewBit.java.bigints;

import java.math.BigInteger;
import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();

        BigInteger b = new BigInteger(num);
        System.out.println(b.isProbablePrime(1) ? "prime" : "not prime");
    }
}
