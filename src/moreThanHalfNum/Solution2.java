package moreThanHalfNum;

//[2,2,2,2,2,1,3,4,5]
public class Solution2 {
    public int MoreThanHalfNum_Solution(int [] array) {
    	if ( array == null ) {
    		return 0;
    	}
    	int result = array[0];
    	int times = 1;
    	for (int i = 1; i < array.length; i++) {
			if ( times == 0) {
				result = array[i];
				times++;
			} 
			if ( result == array[i] ) {
				times++;
			} else {
				times--;
			}
		}
    	int count = 0;
    	for ( int i = 0; i < array.length; i++ ) {
    		if ( result == array[i] ) {
    			count++;
    		}
    	}
    	if (count > ( array.length / 2 ) ) {
    		return result;
    	}
    	return 0;
    }
    public static void main(String[] args) {
		int[] testdata = {2,2,2,2,2,1,3,4,5};
		int result = new Solution2().MoreThanHalfNum_Solution(testdata);
		System.out.println(result);
	}
}