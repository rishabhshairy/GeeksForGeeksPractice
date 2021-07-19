package com.interviewbit.strings;

public class AddBinaryStrings {
    public static void main(String[] args) {
        String a = "100";
        String b = "11";
        System.out.println(addBinary(a, b));
    }

    static String addBinary(String A, String B) {
        int i = A.length() - 1;
        int j = B.length() - 1;
        int lastCharSum = 0;
        String answer = "";

        while (i >= 0 || j >= 0 || lastCharSum == 1) {
            lastCharSum += (i >= 0) ? A.charAt(i) - '0' : 0;
            lastCharSum += (j >= 0) ? B.charAt(j) - '0' : 0;

            answer = (char) (lastCharSum % 2 + '0') + answer;

            // updating carry
            lastCharSum /= 2;
            i--;
            j--;
        }
        return answer;
    }

}
