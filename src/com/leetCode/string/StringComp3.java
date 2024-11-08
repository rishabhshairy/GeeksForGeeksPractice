package com.leetCode.string;

public class StringComp3 {
    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(new StringComp3().compressedString(s));
    }

    /**
     * Trying with 2 pointer
     *
     * @param word
     * @return
     */
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int left = 0;
        while (left < word.length()) {
            int count = 0;
            char curr = word.charAt(left);

            while (left < word.length() && count < 9 && word.charAt(left) == curr) {
                count++;
                left++;
            }
            comp.append(count).append(curr);
        }

        return comp.toString();
    }

    /**
     * Time --> 1033 ms
     *
     * @param word
     * @return
     */
    public String compressedStringLargeTime(String word) {
        String comp = "";
        int maxFreq = 9;

        for (int i = 0; i < word.length(); ) {
            int count = 0;
            int j = i;
            while (j < word.length() && word.charAt(i) == word.charAt(j)) {
                if (count >= maxFreq) {
                    break;
                }
                count++;
                j++;
            }
            comp += Integer.toString(count) + word.charAt(i);
            i = j;
        }
        return comp;
    }
}
