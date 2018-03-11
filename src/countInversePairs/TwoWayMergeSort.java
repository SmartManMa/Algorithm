package countInversePairs;


public class TwoWayMergeSort {
	public void mergeSort( int[] array ) {
		if ( array == null ) {
			return;
		}
		int len = array.length;
		int[] copy = new int[len];
		System.arraycopy(array, 0, copy, 0, len);
		mergeSort(array, copy,0 , len - 1);
	}

	/** 
	  * mergeSort TODO :
	  * @param array
	  * @param copy
	  * @param i
	  * @param len
	  * @author zhiman
	  * @date 2018/03/07 обнГ7:43:45 
	  */
	private void mergeSort(int[] array , int[] copy, int low, int high) {
		if ( low == high ) {
			copy[low] = array[low];
		}
		if ( low < high ) {
			int mid = (low + high) >> 1;
			mergeSort(copy, array,  low, mid);
			mergeSort(copy, array,  mid + 1, high);
			merge(array, copy, low, mid, high);
		}
	}

	/** 
	  * merge TODO :
	  * @param array
	  * @param copy
	  * @param low
	  * @param mid
	  * @param high
	  * @author zhiman
	  * @date 2018/03/07 обнГ7:47:15 
	  */
	private void merge(int[] array, int[] copy, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int k = low;
		while (i <= mid && j <= high) {
			if ( array[i] < array[j] ) {
				copy[k++] = array[i++];
			} else {
				copy[k++] = array[j++];
			}
		}
		while ( i <= mid ) {
			copy[k++] = array[i++];
		}
		while ( j <= high ) {
			copy[k++] = array[j++];
		}
//		for (;low <= high;low++) {
//			 array[low] = copy[low];
//		}
	}
	public static void main(String[] args) {
		int[] array = {1,8,4,6,2,7,6,4,5,3,8,5,6,2,1,3};
		new TwoWayMergeSort().mergeSort(array);
		for (int a : array) {
			System.out.print(a+"--");
		}
	}
}
