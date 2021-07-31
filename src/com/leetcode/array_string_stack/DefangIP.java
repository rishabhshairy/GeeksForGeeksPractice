package com.leetcode.array_string_stack;

public class DefangIP {
    public static void main(String[] args) {
        String ipaddress = "1.1.1.1";
        System.out.println(defangIPaddr(ipaddress));
    }

    static String defangIPaddr(String address) {
        // StringBuilder sb = new StringBuilder(address);
        String s = address.replaceAll("\\.", "[.]");
        return s;
    }
}
