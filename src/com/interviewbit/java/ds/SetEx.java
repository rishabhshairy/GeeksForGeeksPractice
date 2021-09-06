package com.interviewbit.java.ds;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetEx {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Integer[] arr = new Integer[num];

        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        Set<Integer> integerSet = new HashSet<>();
        integerSet.addAll(Arrays.asList(arr));
        System.out.println(integerSet.size());
    }
}
