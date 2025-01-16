package com.company.FlexPortOA;

public class PowerSetOfString {
    public static void main(String[] args) {
        String s = "123";
        int n = s.length();
        for (int i = 0; i < 1 << n; i++) {
            StringBuilder sb = new StringBuilder(s.charAt(0));
            for (int index = 0; index < n; index++) {
                // check if index is set i
                if ((i & (1 << index)) != 0) {
                    sb.append(s.charAt(index));
                }
            }
            System.out.println(sb);
        }
    }
}
