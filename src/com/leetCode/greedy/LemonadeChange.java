package com.leetCode.greedy;

import java.util.Arrays;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five$ = 0;
        int ten$ = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five$++;
            } else if (bills[i] == 10) {
                five$--;
                ten$++;
            } else if (ten$ > 0) {
                five$--;
                ten$--;
            } else {
                // this is conditon for [5,5,5,20]
                five$ -= 3;
            }

            // now check if we are going in negative for $5
            if (five$ < 0) {
                return false;
            }
        }
        return true;
    }
}
