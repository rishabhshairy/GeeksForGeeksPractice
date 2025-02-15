package com.leetCode.arrays.prefixSum;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 1352
 */
public class ProductOfNumbers {

    List<Integer> prefixProducts;
    int len;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1);
        this.len = 0;
    }

    public void add(int num) {
        if (num == 0) {
            prefixProducts = new ArrayList<>();
            prefixProducts.add(1);
            this.len = 0;
        } else {
            prefixProducts.add(num * prefixProducts.get(this.len));
            this.len++;
        }
    }

    public int getProduct(int k) {
        if (k > this.len){
            return 0;
        }
        return prefixProducts.get(this.len) / this.prefixProducts.get(this.len - k);
    }
}
