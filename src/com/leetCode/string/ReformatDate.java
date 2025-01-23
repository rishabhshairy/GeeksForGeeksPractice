package com.leetCode.string;

public class ReformatDate {

    public String reformatDate(String date) {
        String[] dateSplit = date.split(" ");
        String day = findDay(dateSplit[0]);
        String month = findMonth(dateSplit[1]);
        String year = dateSplit[2];
        return year + "-" + month + "-" + (day.length() == 1 ? "0" + day : day);
    }

    private String findMonth(String s) {
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        int mon = -1;
        for (int i = 0; i < month.length; i++) {
            if (s.equals(month[i])) {
                mon = i + 1;
                break;
            }
        }
        return mon > 9 ? String.valueOf(mon) : "0" + mon;
    }

    private String findDay(String s) {
        if (s.length() == 3) {
            return s.substring(0, 1);
        } else {
            return s.substring(0, 2);
        }
    }
}
