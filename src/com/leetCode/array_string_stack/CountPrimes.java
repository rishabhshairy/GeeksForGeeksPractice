package com.leetCode.array_string_stack;

public class CountPrimes {
    public static void main(String[] args) {
        int n = 1500000;
        System.out.println(countPrimes(n));
    }

    static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 1;
        for (int i = 3; i < n; i = i + 2) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
        // below soln is sieve of E
/*        return count;

        boolean[] primes = new boolean[n];
        for(int i = 0;i < n;i++) primes[i] = true;
        for(int i = 2;i*i <= n;i++) {
            if(primes[i]) {
                for(int j = i*2;j < n;j+=i) {
                    primes[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2;i < n;i++) {
            if(primes[i]) count++;
        }
        return count;*/
    }

    static boolean isPrime(int num) {

        int flag = 0;
        for (int i = 3; i * i <= num; i++) {
            if (num % i == 0) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            return true;
        }
        return false;
    }
}
