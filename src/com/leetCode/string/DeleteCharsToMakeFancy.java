package com.leetCode.string;

public class DeleteCharsToMakeFancy {
    public static void main(String[] args) {
        String s = "aaabaaaa";
        System.out.println(new DeleteCharsToMakeFancy().makeFancyString(s));
    }

    public String makeFancyString(String s) {
        if (s.length() < 3) {
            return s;
        }
        int sameCount = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                sameCount++;
            } else {
                sameCount = 1;
            }
            //System.out.println(sameCount);
            if (sameCount < 3) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
