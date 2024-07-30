package com.codingNinja.crackCodingInterview;

public class SlotGame {
    public static void main(String[] args) {
        String orig = "RGYB";
        String guess = "GGRR";
        System.out.println(slotScore(orig, guess));
    }

    public static int slotScore(String original, String guess) {
        // Write your code here.
        int totalPoints = 0;
        StringBuilder og = new StringBuilder(original);
        StringBuilder given = new StringBuilder(guess);

        // Perfect hit
        for (int i = 0; i < 4; i++) {
            if (og.charAt(i) == given.charAt(i)) {
                totalPoints += 2;
                given.setCharAt(i, '#');
                og.setCharAt(i,'#');
            }
        }
        // Pseudo hit
        for (int i = 0; i < 4; i++) {
            if (given.charAt(i) != '#') {
                for (int j = 0; j < 4; j++) {
                    if (og.charAt(j) == given.charAt(i)) {
                        totalPoints += 1;
                        given.setCharAt(i, '#');
                        og.setCharAt(j, '#');
                        break;
                    }
                }
            }
        }
        //System.out.println(given.toString());

        return totalPoints;
    }

}
