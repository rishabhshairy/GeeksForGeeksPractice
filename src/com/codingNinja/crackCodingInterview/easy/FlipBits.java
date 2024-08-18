package com.codingNinja.crackCodingInterview.easy;

import java.util.ArrayList;
import java.util.List;

public class FlipBits {
    public static void main(String[] args) {
        System.out.println(flipBit(438));
    }

    public static int flipBit(int a) {
        // Write your code here.
        String binary = Integer.toBinaryString(a);
        List<Integer> zeroIndexListM = new ArrayList<>();
        // String indexes of zero
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                zeroIndexListM.add(i);
            }
        }
        int maxTrees = Integer.MIN_VALUE;
        System.out.println(zeroIndexListM);
        for (int i = 0; i < zeroIndexListM.size(); i++) {
            int totalOnes = 0;
            if (zeroIndexListM.get(i) < binary.length()) {

                if (i == 0) {
                    totalOnes = Math.abs(0 - zeroIndexListM.get(i)) + Math.abs(zeroIndexListM.get(i) - zeroIndexListM.get(i + 1));
                } else {
                    totalOnes = Math.abs(zeroIndexListM.get(i - 1) - zeroIndexListM.get(i)) +
                            (i + 1 >= zeroIndexListM.size() ? Math.abs(binary.length() - 1 - zeroIndexListM.get(i)) : Math.abs(zeroIndexListM.get(i) - zeroIndexListM.get(i + 1))-1);
                    System.out.println("Total Ones = " + totalOnes);
                }

            }
            maxTrees = Math.max(maxTrees, totalOnes);
        }
        return maxTrees == Integer.MIN_VALUE ? binary.length() : maxTrees;
    }
}

/** Another Approach

public class Solution {
 *

    public static String reverseString(String str) {
 *StringBuilder sb = new StringBuilder(str);
 *sb.reverse();
 *return sb.toString();
 *}
 *
         *

    public static int flipBit(int a) {
 *int currLen = 0;
 *int prevLen = 0;
 *int maxLen = 0;
 *String binaryRepr = "";
 *
 *while (a != 0) {
 *if (a % 2 == 1) {
 *binaryRepr = binaryRepr + "1";
 *} else {
 *binaryRepr = binaryRepr + "0";
 *}
 *a /= 2;
 *}
 *
 *binaryRepr = reverseString(binaryRepr);
 *
 *int count = 0;
 *int n = binaryRepr.length();
 *
 *for (int i = 0; i < n; i++) {
 *if (binaryRepr.charAt(i) == '0') {
 *count += 1;
 *}
 *}
 *
 *         // Handling edge cases.
 *if (count == 0) {
 *return 1;
 *} else if (count == n) {
 *return n;
 *}
 *
 *for (int i = 0; i < n; i++) {
 *
 *             // If Current bit is a 1 then increment 'CURRLEN' by 1.
 *if (binaryRepr.charAt(i) == '1') {
 *currLen += 1;
 *}
 *
 *             // If Current bit is a 0 then check next bit of 'A'.
 *             else if (binaryRepr.charAt(i) == '0') {
 *i += 1;
 *
 *                 // Update 'PREVLEN' to 0 (if next bit is 0) or 'CURRLEN' (if next bit is 1).
 *if (i < n && binaryRepr.charAt(i) == '0') {
 *prevLen = 0;
 *} else {
 *prevLen = currLen;
 *}
 *
 *                 // If two consecutively bits are 0 then 'CURRLEN' also will be 0.
 *currLen = 0;
 *i -= 1;
 *}
 *
 *             // Update 'MAXLEN' if required.
 *maxLen = Math.max(prevLen + currLen, maxLen);
 *}
 *
 *         // We can always have a sequence of at least one 1, which is the fliped bit.
 *return maxLen + 1;
 *
 *}
 *
}
 */
