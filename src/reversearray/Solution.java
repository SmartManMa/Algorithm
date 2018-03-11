package reversearray;

import java.util.TreeSet;

public class Solution {
	public int minNumberInRotateArray(int[] array) {
		int len = array.length;
		if ( len == 0) {
			return 0;
		}
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < len; i++) {
			int pre = array[(i + len - 1) % len];
			int mid = array[i];
			int last = array[(i + len + 1) % len];
			if (mid <= pre && mid <= last) {
				set.add(mid);
			}
		}
		return set.first();
	}

	public static void main(String[] args) {
		int[] array = { 3, 3, 3, 1, 2 };
		System.out.println(new Solution().minNumberInRotateArray(array));
	}
}