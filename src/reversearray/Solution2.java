package reversearray;

import java.util.TreeSet;

public class Solution2 {
	public int minNumberInRotateArray(int[] array) {
		int len = array.length;
		if ( len == 1 ) {
			return array[0];
		}
		for (int i = 0; i < len; i++) {
			int pre = array[(i + len - 1) % len];
			int mid = array[i];
			int last = array[(i + len + 1) % len];
			if (mid <= pre && mid <= last) {
				if ( mid == pre || mid == last ) {
					return getMin(array,len);
				}
				return mid;
			}
		}
		return 0;
	}

	private int getMin(int[] array) {
		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}
		return min;
	}
	private int getMin(int[] array,int len) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		for (int i = 0; i < len; i++) {
			int pre = array[(i + len - 1) % len];
			int mid = array[i];
			int last = array[(i + len + 1) % len];
			if (mid <= pre && mid <= last) {
				treeSet.add(mid);
			}
		}
		return treeSet.first();
	}

	public static void main(String[] args) {
		int[] array = {1};
		System.out.println(new Solution2().minNumberInRotateArray(array));
	}
}