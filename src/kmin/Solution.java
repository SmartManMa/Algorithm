package kmin;

import java.util.ArrayList;

public class Solution {
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		int len = input.length;
		if (input == null || len < k || k <= 0) {
			return result;
		}
		int low = 0;
		int high = len - 1;
		int key = k - 1;
		int index = partition(input, low, high);
		while (index != key) {
			if (index < key) {
				index = partition(input, index + 1, high);
			} else {
				index = partition(input, index - 1, high);
			}
		}
		
		for (int i = 0; i <= key; i++) {
			result.add(input[i]);
		}
		return result;
	}

	private int partition(int[] array, int low, int high) {
		int temp = array[low];
		while (high > low) {
			while (high > low && array[high] >= temp) {
				high--;
			}
			if (high > low && array[high] < temp) {
				array[low] = array[high];
			}
			while (high > low && array[low] <= temp) {
				low++;
			}
			if (high > low && array[low] > temp) {
				array[high] = array[low];
			}
		}
		array[low] = temp;
		return low;
	}
}