package com.leetCode.string.medium;

public class SumOfBeautyAllSubstr {
    public static void main(String[] args) {
        String s = "aabcbaa";
        SumOfBeautyAllSubstr obj = new SumOfBeautyAllSubstr();
        System.out.println(obj.beautySum(s));
    }

    public int beautySum(String s) {

        int beauty = 0;

        for (int i = 0; i < s.length(); i++) {
            // calculate freq for every substring
            int[] freq = new int[26];
            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;
                int[] maxMin = getMaxMinCount(freq);
                beauty += (maxMin[1] - maxMin[0]);
            }
        }
        return beauty;
    }

    private int[] getMaxMinCount(int[] freq) {
        int[] res = new int[2];
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                minVal = Math.min(minVal, freq[i]);
                maxVal = Math.max(maxVal, freq[i]);
            }
        }
        res[0] = minVal;
        res[1] = maxVal;
        return res;
    }
}
