package com.stackQueue.monotonicStackQueue;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] a = {-2,-2,1,-2};
        AsteroidCollision obj = new AsteroidCollision();
        obj.asteroidCollision(a);
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
            } else if (asteroids[i] < 0) {
                if (stack.peek() > 0) {
                    while (!stack.isEmpty() && Math.abs(asteroids[i]) >= stack.peek()) {
                        stack.pop();
                    }
                } else {
                    stack.push(asteroids[i]);
                }
            } else {
                stack.push(asteroids[i]);
            }
            System.out.println(stack);
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}
