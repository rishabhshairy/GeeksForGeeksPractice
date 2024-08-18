package com.leetCode.arrays;

public class BasicCal2 {
    public static void main(String[] args) {
        String exp = " 3+5 / 2 ";
        calculate(exp);
    }

/*    public static int calculate(String s) {
        s = s.trim();
        Stack<Integer> nums = new Stack<>();
        int temp = 0;
        char sign = '+';
        char[] exp = s.toCharArray();

        for (int i = 0; i < exp.length; i++) {
            char ch = exp[i];
            if (Character.isDigit(ch)) {
                temp = temp * 10 + ch - '0';
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    nums.push(temp);
                } else if (sign == '-') {
                    nums.push(-temp);
                } else if (sign == '*') {
                    nums.push(nums.pop() * temp);
                } else if (sign == '/') {
                    nums.push(nums.pop() / temp);
                }

                sign = ch;
                temp = 0;
            }
        }
        int res = 0;
        while (!nums.isEmpty()) {
            res += nums.pop();
        }
        return res;
    }*/

    // Generic Solution

    public static int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int num = 0, tmp = 0, res = 0;
        char op = '+';
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                tmp = tmp * 10 + c - '0';
            } else if (c != ' ') {
                //process the numerical value of string so far; based on what 'op' we have before it
                num = cal(num, tmp, op);
                if (c == '+' || c == '-') {
                    res += num;
                    num = 0;
                }
                // reset
                tmp = 0;
                op = c;
            }
        }
        return res + cal(num, tmp, op);
    }

    private static int cal(int num, int tmp, char op) {
        if (op == '+') return num + tmp;
        else if (op == '-') return num - tmp;
        else if (op == '*') return num * tmp;
        else return num / tmp;
    }
}
