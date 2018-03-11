package findMaxSumOfSubarray;

public class Solution {
	
	public int FindGreatestSumOfSubArray(int[] array) {
		if ( array == null ) {
			return 0;
		}
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if ( sum < 0 ) {
				sum = array[i];
			} else {
				sum += array[i];
			}
			//1,-2,3,10,-4,7,2,-5
			if ( sum > maxSum ) {
				maxSum = sum;
			}	
		}
		return maxSum;
	}
	public static void main(String[] args) {
		int[] array = {1,-2,3,10,-4,7,2,-5};
		int max = new Solution().FindGreatestSumOfSubArray(array);
		System.out.println(max);
	}
}