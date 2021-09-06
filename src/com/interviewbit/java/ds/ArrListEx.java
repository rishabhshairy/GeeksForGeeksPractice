package com.interviewbit.java.ds;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrListEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> res = new ArrayList<>();

        int n = sc.nextInt();
        while (n > 0) {
            res.add(n);
            n = sc.nextInt();
        }
        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.print(res.get(i) +" ");
        }
        sc.close();
    }
}
