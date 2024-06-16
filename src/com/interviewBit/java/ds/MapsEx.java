package com.interviewBit.java.ds;

import java.util.HashMap;
import java.util.Scanner;

public class MapsEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hm = new HashMap<>();

        int t = sc.nextInt();

        while (t > 0) {
            String name = sc.next();
            int marks = sc.nextInt();
            hm.put(name, marks);
            t--;
        }

        int q = sc.nextInt();

        while (q-- > 0) {
            String name = sc.next();
            if (hm.containsKey(name)) {
                System.out.println(hm.get(name));
            } else {
                System.out.println("Not Found");
            }

        }

    }
}
