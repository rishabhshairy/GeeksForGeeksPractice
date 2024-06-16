package com.interviewBit.java.strings;

import java.util.Scanner;

public class IntroStringEx {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String a = inp.next();
        String b = inp.next();

        System.out.println(a.length() + b.length());
        if (a.compareTo(b) >= 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        System.out.println(a.toUpperCase() + " " + b.toUpperCase());

    }
}
