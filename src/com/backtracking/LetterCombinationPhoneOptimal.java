package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationPhoneOptimal {
    public static void main(String[] args) {
        LetterCombinationPhoneOptimal obj = new LetterCombinationPhoneOptimal();
        System.out.println(obj.letterCombinations("237"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String[] strMap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits.length() == 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        findPhoneNumCombinations(0, digits, sb, result, strMap);
        return result;
    }

    private void findPhoneNumCombinations(int length, String digits, StringBuilder sb, List<String> result, String[] strMap) {
        if (length == digits.length()) {
            result.add(sb.toString());
            return;
        }
        // find first letter
        char ch = digits.charAt(length);
        String letters = strMap[ch - '0'];
        for (char c :
                letters.toCharArray()) {
            sb.append(c);
            findPhoneNumCombinations(length + 1, digits, sb, result, strMap);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
