package findContinuousSequence;

import java.util.ArrayList;

public class Solution2 {
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		if (array == null) {
			return null;
		}
		ArrayList<Integer> result = new ArrayList<>();
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			int ss = array[low] + array[high];
			if ( ss < sum ) {
				low++;
			}
			if ( ss > sum ) {
				high--;
			}
			if (ss == sum) {
				result.add(array[low]);
				result.add(array[high]);
				return result;
			}
		}
		return result;
	}

//	public static void main(String[] args) {
//		int[] array = {1,2,4,7,11,15};
//		ArrayList<Integer> list = new Solution2().FindNumbersWithSum(array,0);
//		for (Integer arr : list) {
//			System.out.print(arr + "+");
//		}
//	}
}