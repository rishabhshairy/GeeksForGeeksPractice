package com.leetCode.binarySearch.med;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionSystem {
    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        SearchSuggestionSystem obj = new SearchSuggestionSystem();
        obj.suggestedProducts(products, searchWord);
    }

    /**
     * TODO:: Binary Search Solution
     */

    /**
     * Brute force
     * @param products
     * @param searchWord
     * @return
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            result.add(new ArrayList<>());
        }
        Arrays.sort(products);
        String s = "";
        for (int i = 0; i < searchWord.length(); i++) {
            s += searchWord.charAt(i);
            int count = 0;
            for (int j = 0; j < products.length; j++) {
                if (products[j].startsWith(s)){
                    result.get(i).add(products[j]);
                    count++;
                }
                if (count==3){
                    break;
                }
            }
        }
        System.out.println(result);
        return result;
    }
}
