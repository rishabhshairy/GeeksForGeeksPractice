package com.stackQueue.monotonicStackQueue;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] a = {4, 7, 1, 1, 2, -3, -7, 17, 15, -18,-19};
        AsteroidCollision obj = new AsteroidCollision();
        obj.asteroidCollision(a);
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroids[i])) { // equal size check
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                }
            }
            System.out.println(stack);

        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}
