package com.leetcode.array_string_stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ProductOfNumbersSol {
    public static void main(String[] args) {

    }

    ArrayList<Integer> nums;

    public ProductOfNumbersSol() {
        nums = new ArrayList<>();
        nums.add(1);
    }

    public void add(int num) {
        if (num > 0) {
            nums.add(nums.get(nums.size() - 1) * num);
        } else {
            nums = new ArrayList<>();
            nums.add(1);
        }
    }

    public int getProduct(int k) {

        int n = nums.size();
        System.out.println(nums.get(n - 1));
        System.out.println(nums.get(n - k - 1));

        return k < n ? nums.get(n - 1) / nums.get(n - k - 1) : 0;
    }
}
