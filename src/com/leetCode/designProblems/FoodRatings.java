package com.leetCode.designProblems;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodRatings {
    static class Food implements Comparable<Food> {
        int rating;
        String foodName;

        public Food(int rating, String foodName) {
            this.rating = rating;
            this.foodName = foodName;
        }

        @Override
        public int compareTo(Food other) {
            if (other.rating == this.rating) {
                return this.foodName.compareTo(other.foodName);
            }
            return -1 * Integer.compare(this.rating, other.rating);
        }
    }

    Map<String, Integer> foodRatingMap;
    Map<String, String> foodCuisineMap;
    Map<String, PriorityQueue<Food>> cuisineToFoodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foodRatingMap = new HashMap<>();
        this.foodCuisineMap = new HashMap<>();
        this.cuisineToFoodMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);

            cuisineToFoodMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>())
                                                .add(new Food(ratings[i], foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        foodRatingMap.put(food,newRating);
        String cuisine = foodCuisineMap.get(food);
        cuisineToFoodMap.get(cuisine).offer(new Food(newRating,food));
    }

    public String highestRated(String cuisine) {
        Food highestRatedFood = cuisineToFoodMap.get(cuisine).peek();

        // remove older entry from PQ
        while (highestRatedFood.rating != foodRatingMap.get(highestRatedFood.foodName)){
            cuisineToFoodMap.get(cuisine).poll();
            highestRatedFood = cuisineToFoodMap.get(cuisine).peek();
        }
        return highestRatedFood.foodName;
    }
}

/**
 * Below solution gives TLE
 */
class FoodRatingsTLE {
    String[] foods;
    String[] cuisines;
    int[] ratings;

    public FoodRatingsTLE(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
    }

    public void changeRating(String food, int newRating) {
        for (int i = 0; i < foods.length; i++) {
            if (foods[i].equals(food)) {
                ratings[i] = newRating;
            }
        }
    }

    public String highestRated(String cuisine) {
        String food = "";
        int maxRating = Integer.MIN_VALUE;
        for (int i = 0; i < cuisines.length; i++) {
            if (cuisines[i].equals(cuisine)) {
                if (maxRating < ratings[i]) {
                    food = foods[i];
                    maxRating = ratings[i];
                } else if (maxRating == ratings[i]) {
                    if (foods[i].compareTo(food) < 0) {
                        food = foods[i];
                    }
                }
            }
        }
        return food;
    }
}
