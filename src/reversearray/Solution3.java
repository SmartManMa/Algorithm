package reversearray;


public class Solution3 {
	public int minNumberInRotateArray(int[] array) {
		int len = array.length;
		if (len == 0) {
			return 0;
		}
		int index1= 0;
		int mid = 0;
		int index2 = array.length - 1;
		while ( array[index1] >= array[index2] ) {
			mid = ( index1 + index2 ) / 2;

			if (array[mid] == array[index1] && array[mid] == array[index2]) {
				return getMin(array);
			}
			if ( array[mid] >= array[index1] ) {
				index1 = mid;
			} 
			if ( array[mid] <= array[index2] ) {
				index2 = mid;
			}
			if ( index2 - index1 == 1) {
				mid = index2;
				break;
			}
		}
		return array[mid];
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

	public static void main(String[] args) {
		int[] array = { 1,2 };
		System.out.println(new Solution3().minNumberInRotateArray(array));
	}
}