package com.interviewBit.java.flowcontrol;

import java.util.Scanner;

public class IfElseEx {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int M = inp.nextInt();
        inp.close();

        if (M % 3 == 0 && M % 5 == 0) {
            System.out.println("Good Number");
        } else if (M % 3 == 0 && M % 5 != 0) {
            System.out.println("Bad Number");
        }
        if (M % 3 != 0 && M % 5 == 0) {
            System.out.println("Poor Number");
        } else {
            System.out.println("-1");
        }
    }
}
