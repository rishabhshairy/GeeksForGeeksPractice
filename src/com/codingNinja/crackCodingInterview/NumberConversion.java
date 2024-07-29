package com.codingNinja.crackCodingInterview;

public class NumberConversion {
    public static void main(String[] args) {
        System.out.println(conversion(349, 448));
    }

    public static int conversion(int n, int m) {
        // Write your code here.
        int opsCount = 0;
        String nBits = Integer.toBinaryString(n);
        String mBits = Integer.toBinaryString(m);

        StringBuilder nBitPrefix = new StringBuilder();
        if (nBits.length() < 32) {
            for (int i = 0; i < 32 - nBits.length(); i++) {
                nBitPrefix.append("0");
            }
        }

        StringBuilder mBitsPrefix = new StringBuilder();
        if (mBits.length() < 32) {
            for (int i = 0; i < 32 - mBits.length(); i++) {
                mBitsPrefix.append("0");
            }
        }

        nBits = nBitPrefix.toString() + nBits;
        mBits = mBitsPrefix.toString() + mBits;

        for (int i = 0; i < 32; i++) {
            if (nBits.charAt(i) != mBits.charAt(i)) {
                opsCount++;
            }
        }

        return opsCount;
    }

    /**
     * @param n
     * @param m
     * @return
     */
    public static int conversionBitwiseSolution(int n, int m) {
        return 0;
    }
}
