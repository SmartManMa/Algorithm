package getNumberOfK;

public class Solution {
	public int GetNumberOfK(int[] array, int k) {
		int count = 0;
		if (array == null) {
			return count;
		}

		int index = binarySearchs(array, k, 0, array.length - 1);
		if (index != -1) {
			for (int i = index; i < array.length && array[i] == k; i++) {
				count++;
			}
			for (int j = index - 1; j >= 0 && array[j] == k; j--) {
				count++;
			}
		}
		return count;
	}

	/**
	 * binarySearch TODO :
	 * 
	 * @param array
	 * @param k
	 * @return
	 * @author zhiman
	 * @param high
	 * @param low
	 * @date 2018/03/07 ÏÂÎç3:55:45
	 */
	private int binarySearch(int[] array, int target, int low, int high) {
		int index = -1;
		if (low < 0 || high < 0) {
			return index;
		}
		int mid = (low + high) >> 1;
		if (array[mid] == target) {
			index = mid;
		} else if (array[mid] > target) {
			index = binarySearch(array, target, low, mid - 1);
		} else {
			index = binarySearch(array, target, mid + 1, high);
		}
		return index;
	}

	private int binarySearchs(int[] array, int target, int low, int high) {
		int index = -1;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (array[mid] == target) {
				index = mid;
				break;
			} else if( array[mid] > target ) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return index;
	}
	 public static void main(String[] args) {
	 int[] array = {3};
	 System.out.println(new Solution().GetNumberOfK(array, 3));
	 }
}