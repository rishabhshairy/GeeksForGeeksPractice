package com.interviewBit.java.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderEx {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(reader);
        int ip1 = Integer.parseInt(bf.readLine());
        int ip2 = Integer.parseInt(bf.readLine());
        System.out.print(ip1+" "+ip2);
    }
}
