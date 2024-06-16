package com.leetCode.array_string_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ProductOfNumbers {
    Deque<Integer> nums;

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
        productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
        productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32
    }

    public ProductOfNumbers() {
        nums = new ArrayDeque<>();
    }

    public void add(int num) {
        nums.offer(num);
    }

    public int getProduct(int k) {
        // correct solution but will give TLE for larger inputs
        int answer = 1;
        Deque<Integer> tempQueue = new ArrayDeque<>();
        System.out.println(nums.toString());
        for (int i = 0; i < k; i++) {
            int num = nums.removeLast();
            answer = answer * num;
            tempQueue.offer(num);
        }
        while (!tempQueue.isEmpty()) {
            nums.addLast(tempQueue.pollLast());
        }
        return answer;
    }
}
