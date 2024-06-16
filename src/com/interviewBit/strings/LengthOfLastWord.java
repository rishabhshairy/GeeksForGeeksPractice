package com.interviewBit.strings;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

    static int lengthOfLastWord(final String A) {
//        String[] allWord = A.split(" ");
//        if (allWord.length > 0) {
//            int n = allWord.length;
//            return allWord[n - 1].length();
//        }
//        return 0;
        int wordlength = 0;
        for (char c :
                A.toCharArray()) {
            if (c != ' ') {
                wordlength++;
            } else {
                wordlength = 0;
            }
        }
        return wordlength;
    }
}
