package com.leetCode.string.medium;

import java.util.List;

public class AddSpacesToString {

    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8, 13, 15};
        AddSpacesToString obj = new AddSpacesToString();
        System.out.println(obj.addSpaces(s, spaces));

    }

    /**
     * TC O(n+m)
     * @param s
     * @param spaces
     * @return
     */
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        sb.ensureCapacity(s.length()+spaces.length);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < spaces.length && i == spaces[j]) {
                sb.append(" ");
                j++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
