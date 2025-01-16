package com.leetCode.bitManipulation;

/**
 * LC 2429
 */
public class MinimizeXOR {
    public static void main(String[] args) {
        int num1 = 7;
        int num2 = 5;
        MinimizeXOR obj = new MinimizeXOR();
        int ans = obj.minimizeXor(num1, num2);
        System.out.println(ans);
    }

    private int minimizeXor(int num1, int num2) {
        if (num1 == num2) {
            return num1;
        }

        int targetBit = Integer.bitCount(num2);
        int result = num1;
        int resultBit = Integer.bitCount(result);

        int currentBit = 0;

        // add bits to result if result  have less than target bit
        while (resultBit < targetBit) {
            if (!isBitSet(result, currentBit)) {
                result = setBit(result, currentBit);
                resultBit++;
            }
            currentBit++;
        }

        while (resultBit > targetBit) {
            if (isBitSet(result, currentBit)) {
                result = unset(result, currentBit);
                resultBit--;
            }
            currentBit++;
        }
        return result;
    }

    private int unset(int num, int currentBit) {
        return ~(1 << currentBit) & num;
    }

    private int setBit(int num, int currentBit) {
        return (1 << currentBit) | num;
    }

    //
    private boolean isBitSet(int num, int currentBit) {
        return ((1 << currentBit) & num) != 0;
    }

    /**
     * My Approach
     * Not Optimal
     *
     * @param num1
     * @param num2
     * @return
     */
    public int minimizeXorNotOptimal(int num1, int num2) {
        if (num1 == num2) {
            return num1;
        }
        int num2SetBits = findSetBits(num2);
        int mini = Integer.MAX_VALUE;
        int res = -1;
        for (int i = num2 - 1; i >= 1; i--) {
            if (findSetBits(i) == num2SetBits) {
                int currMin = num1 ^ i;
                if (mini > currMin) {
                    mini = currMin;
                    res = i;
                }
            }
        }
        return res;
    }

    private int findSetBits(int num2) {
        int count = 0;
        while (num2 > 0) {
            count += (num2 & 1);
            num2 >>= 1;
        }
        return count;
    }
}
