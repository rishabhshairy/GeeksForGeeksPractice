package com.geeksForGeeks.strings;

public class CheckStringRotation {
    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "ACBD";
        System.out.print(isRotations(s1, s2));
    }

    static boolean isRotations(String s1, String s2) {
        String temp = s1 + s1;
        return s1.length() == s2.length() && temp.contains(s2);
    }
}
