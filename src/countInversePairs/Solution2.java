package countInversePairs;
public class Solution2 {
    public int InversePairs(int[] array) {
    	if (array == null || array.length <= 1) {
    		return 0;
    	}
    	int len = array.length;
    	int[] copy = new int[len];
    	System.arraycopy(array, 0, copy, 0, len);
    	int count = countInversePairs(array, copy, 0, len - 1);
        return count;
    }

	/** 
	  * countInversePairs TODO :
	  * @param array
	  * @param copy
	  * @param i
	  * @param j
	  * @return
	  * @author zhiman
	  * @date 2018/03/05 ÏÂÎç8:31:58 
	  */
	private int countInversePairs(int[] array, int[] copy, int start, int end) {
		if ( start == end) {
			
			return 0;
		}
		int mid = ( end + start ) >> 1;
    	int left = countInversePairs(array, copy, start, mid);
    	int right = countInversePairs(array, copy,  mid+1, end);
    	int leftEnd = mid;
    	int rightEnd = end;
    	int indexCopy = end;
    	int count = 0;
    	while (leftEnd >= start && rightEnd >= leftEnd + 1) {
    		if ( array[leftEnd] > array[rightEnd] ) {
    			count += rightEnd - leftEnd;
    			copy[indexCopy--] = array[leftEnd--];
    			
    		} else {
    			copy[indexCopy--] = array[rightEnd--];
    		}
    	}
    	while ( leftEnd >= start ) {
    		copy[indexCopy--] = array[leftEnd--];
    	}
    	while ( rightEnd > leftEnd ) {
    		copy[indexCopy--] = array[rightEnd--];
    	}
		return left + right + count;
	}
	public static void main(String[] args) {
		int[] array = {7,5,6,4};
		System.out.println(new Solution2().InversePairs(array));
	}
}