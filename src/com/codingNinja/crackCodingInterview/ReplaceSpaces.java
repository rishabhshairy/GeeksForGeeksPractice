package com.codingNinja.crackCodingInterview;

public class ReplaceSpaces {
    public static void main(String[] args) {
        System.out.println(replaceSpaces(new StringBuilder("Coding Ninjas Is A Coding Platform")));
    }

    public static StringBuilder replaceSpaces(StringBuilder str) {
        // Write your code here.
        StringBuilder result = new StringBuilder();

        String[] splits = str.toString().split(" ");
        for (int i = 0; i < splits.length; i++) {

            if (i == splits.length - 1) {
                result.append(splits[i]);
                break;
            }
            result.append(splits[i]).append("@40");
        }
        return result;
    }
}
