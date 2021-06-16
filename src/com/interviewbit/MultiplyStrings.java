package com.interviewbit;

public class MultiplyStrings {
    public static void main(String[] args) {
        String s1 = "1";
        String s2 = "0";
        System.out.println(multiply(s1, s2));
    }

    static String multiply(String A, String B) {

        if (A.length()==1 && A.charAt(0)=='0'){
            return "0";
        }
        if (B.length()==1 && B.charAt(0)=='0'){
            return "0";
        }


        int[] res = new int[A.length() + B.length()];
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                res[i + j + 1] += (A.charAt(i) - '0') * (B.charAt(j) - '0');
            }
        }
        int carry = 0;
        for (int i = res.length - 1; i >= 0; i--) {
            int val = res[i] + carry;
            res[i] = val % 10;
            carry = val / 10;
        }
        StringBuilder sb = new StringBuilder();

        int checkLeadingZero = 0;
        while (checkLeadingZero < res.length && res[checkLeadingZero] == 0) {
            checkLeadingZero++;
        }

        //append answer
        while (checkLeadingZero < res.length) {
            sb.append(res[checkLeadingZero]);
            checkLeadingZero++;
        }
        return sb.toString();
    }
}


// for short length arrays
/*        for (int i = B.length() - 1; i >= 0; i--) {
            sum += numA * (Long.parseLong(String.valueOf(B.charAt(i))) * Math.pow(10, powerCoeff));
            powerCoeff++;
        }*/