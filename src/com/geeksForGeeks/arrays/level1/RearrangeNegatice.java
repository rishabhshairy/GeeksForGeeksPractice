package com.geeksForGeeks.arrays.level1;

public class RearrangeNegatice {
	public static void main(String[] args) {
		int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		shiftAll(arr, 0, arr.length - 1);
		display(arr, arr.length - 1);
	}

	static void shiftAll(int arr[], int left, int right) {
		while (left <= right) {
			if (arr[left] < 0 && arr[right] < 0) {
				left++;
			} else if (arr[left] >= 0 && arr[right] < 0) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			} else if (arr[left] >= 0 && arr[right] >= 0) {
				right--;
			} else {
				left++;
				right--;
			}
		}
	}

	static void display(int[] arr, int right) {

		// Loop to iterate over the element
		// of the given array
		for (int i = 0; i <= right; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}
}
