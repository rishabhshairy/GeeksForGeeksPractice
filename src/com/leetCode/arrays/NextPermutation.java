package com.leetCode.arrays;

/**
 * https://leetcode.com/problems/next-permutation/description/
 */
public class NextPermutation {
    public static void main(String[] args) {
//        int[] arr = new int[]{2, 1, 5, 4, 3, 0, 0};
        int[] arr = new int[]{3, 2, 1};
        nextPermutation(arr);
        for (int num :
                arr) {
            System.out.println(num);
        }
    }

    public static void nextPermutation(int[] nums) {

        // First find break point from back of array;
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // if index is -1 --> reverse the current array
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // Now swap the index position with smaller element from back of array
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }
        // now sort or reverse the array from index + 1 to end of array
        reverse(nums, index + 1, nums.length-1);

    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
/*
    // below Code is brute force approach for finding all permutations and return next one
    public static void nextPermutation(int[] nums) {
        List<List<Integer>> allPermutation = new ArrayList<>();
        List<Integer> firstPerm = Arrays.stream(nums).boxed().collect(Collectors.toList());
        System.out.println(firstPerm);
        //Arrays.sort(nums);
        findAllPermutation(0, nums, allPermutation);

        int index = 0;
        for (List<Integer> perms :
                allPermutation) {
            if (perms.equals(firstPerm)) {
                break;
            }
            index++;
        }
        // check if index is last element
        System.out.println(allPermutation);
        index = index == allPermutation.size() - 1 ? 0 : index + 1;

        int i = 0;
        // copying back to nums
        for (Integer num :
                allPermutation.get(index)) {
            nums[i++] = num;
        }
        for (int num :
                nums) {
            System.out.println(num);
        }
    }

    private static void findAllPermutation(int index, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length) {
            // copy the ds to ans
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            findAllPermutation(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    */
}
