package com.interviewbit;

public class AtoI {
    public static void main(String[] args) {
        String num = "-54332872018247709407 4 54";
        System.out.println(atoi(num));
    }

    static int atoi(final String A) {
        String str = A.trim();
        int sign = 1;
        int i = 0;
        long ans = 0;
        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
            sign = str.charAt(i) == '-'? -1:1;
            i++;
        }

        for(; i<str.length(); i++){
            char c = str.charAt(i);
            if(!Character.isDigit(c))
                return (int)(sign * ans);

            ans = 10 * ans + c - '0';
            if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
                return sign == 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
        }
        return (int)(sign * ans);

    }
}
