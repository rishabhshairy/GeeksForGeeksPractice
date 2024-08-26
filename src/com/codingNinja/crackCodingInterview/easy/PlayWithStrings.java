package com.codingNinja.crackCodingInterview.easy;

import java.util.HashSet;
import java.util.Set;

public class PlayWithStrings {
    public static void main(String[] args) {

    }

    public static boolean checkUnique(String s) {
        // Write your code here.
        Set<Character> uniqueChars = new HashSet<>();
        for (Character c :
                s.toCharArray()) {
            if (uniqueChars.contains(c)){
                return false;
            }
            uniqueChars.add(c);
        }
        return true;
    }
}
