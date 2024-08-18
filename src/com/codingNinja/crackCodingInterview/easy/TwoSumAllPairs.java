package com.codingNinja.crackCodingInterview.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSumAllPairs {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
//        arr.addAll(List.of(2, 7, 11, 13));
        arr.addAll(List.of(1,-1,-1,2,2));
        twoSum(arr, 1, 5);
    }

    public static ArrayList<Pair<Integer, Integer>> twoSum(List<Integer> arr, int target, int n) {
        // Write your code here.
        ArrayList<Pair<Integer, Integer>> ans = new ArrayList<>();
        Collections.sort(arr);

        int left = 0;
        int right = arr.size() - 1;

        while (left < right) {
            int currSum = arr.get(left) + arr.get(right);
            if (currSum == target) {
                Pair<Integer, Integer> pair = new Pair<>(arr.get(left), arr.get(right));
                ans.add(pair);
                left++;
                right--;
            } else if (currSum > target) {
                right--;
            } else {
                left++;
            }
        }
        if (ans.isEmpty()){
            ans.add(new Pair<>(-1,-1));
            return ans;
        }
        return ans;
    }
}

class Pair<T1 extends Integer, T2 extends Integer> {

    T1 num1;
    T2 num2;

    public Pair(T1 num1, T2 num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }
}
