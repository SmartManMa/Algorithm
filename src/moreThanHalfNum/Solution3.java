package moreThanHalfNum;

//[2,2,2,2,2,1,3,4,5]
public class Solution3 {
	public int MoreThanHalfNum_Solution(int[] array) {
		if (array == null) {
			return 0;
		}
		int len = array.length;
		int midIndex = len >> 1;
		int low = 0;
		int high = len - 1;
		int index = partition(array, low, high);
		while ( index != midIndex ) {
			if ( index < midIndex ) {
				index = partition(array, index+1, high);
			} else {
				index = partition(array, index-1, high);
			}
		}
		// 检查index对应的个数是否大于一半
    	int count = 0;
    	for ( int i = 0; i < len; i++ ) {
    		if ( array[ midIndex ] == array[i] ) {
    			count++;
    		}
    	}
    	if ( count > ( array.length / 2 ) ) {
    		return array[ midIndex ];
    	}
    	return 0;
	}

	/**
	 * partition TODO :
	 * 
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 * @author zhiman
	 * @date 2018/02/26 下午4:15:19
	 */
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

	public static void main(String[] args) {
		int[] testdata = { 2, 2, 2, 2, 2, 1, 3, 4, 5 };
		int result = new Solution3().MoreThanHalfNum_Solution(testdata);
		System.out.println(result);
	}
}