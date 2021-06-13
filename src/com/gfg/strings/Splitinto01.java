package com.gfg.strings;

public class Splitinto01 {
    public static void main(String[] args) {
        String binaryString = "0100110101";
        System.out.println(count(binaryString));
    }

    static int count(String s) {
        int countZero = 0;
        int countOne = 0;
        int totalSubString = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                countZero++;
            }
            if (s.charAt(i) == '1') {
                countOne++;
            }
            if (countOne == countZero) {
                totalSubString++;
                countOne = 0;
                countZero = 0;
            }
        }
        return totalSubString > 0 ? totalSubString : -1;
    }
}
