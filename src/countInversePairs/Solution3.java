package countInversePairs;
public class Solution3 {
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
	  * @date 2018/03/05 下午8:31:58 
	  */
	private int countInversePairs(int[] array, int[] copy, int leftstart, int rightend) {
		if ( leftstart == rightend) {
			//copy[leftstart] = array[leftstart];
			return 0;
		}
		int mid = (leftstart + rightend) >> 1;
    	int leftend = mid;
    	int rightstart = mid + 1;
    	int left = countInversePairs(copy,array,leftstart,leftend)% 1000000007 ;
    	int right = countInversePairs(copy,array,rightstart,rightend)% 1000000007;
    	int indexCopy = rightend;
    	int count = 0;
    	int j=rightend;
    	while ( leftend >= leftstart && j >= rightstart ) {
    		if ( array[leftend] >  array[j]) {
    			copy[indexCopy--] = copy[leftend--];
    			count += j - rightstart + 1 ;
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
    		} else {
    			copy[indexCopy--] = array[j--];
    		}
    	}
    	// 将剩下元素合并到copy中
    	while ( leftend >= leftstart ) {
    		copy[indexCopy--] = copy[leftend--];
    	}
    	while ( j >= rightstart ) {
    		copy[indexCopy--] = array[j--];
    	}
    	for (int k = leftstart; k <= rightend; k++) {
    		array[k] = copy[k];
    	}

		return (left + right + count) % 1000000007;
	}
	public static void main(String[] args) {
		int[] array = {7,5,6,4};
		System.out.println(new Solution3().InversePairs(array));
	}
}