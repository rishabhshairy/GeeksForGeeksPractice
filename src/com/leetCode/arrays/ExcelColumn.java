package com.leetCode.arrays;

public class ExcelColumn {
    public static void main(String[] args) {
        int col = Integer.MAX_VALUE;
        System.out.println(convertToTitle(23));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append('A' + columnNumber % 26);
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
