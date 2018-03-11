package uglyNumber;

public class Solution {
	public int GetUglyNumber_Solution(int index) {
		if ( index <=0 ) {
			return 0;
		}
		int[] uglyNumArr = new int[ index ];
		// 初始丑数
		uglyNumArr[0] = 1;
		int nextUglyNumIndex = 1;
		int critical_2 = 0, critical_3 = 0, critical_5 = 0;
		while ( nextUglyNumIndex < index ) {
			
			int a = uglyNumArr[critical_2]*2;
			int b = uglyNumArr[critical_3]*3;
			int c = uglyNumArr[critical_5]*5;
			
			int nextUglyNum  = getMinUglyNum(a, b, c);
			
			uglyNumArr[nextUglyNumIndex] = nextUglyNum;
			// nextUglyNum是当前数组中最大的丑数
			while ( uglyNumArr[critical_2]*2 <= nextUglyNum ) {
				critical_2++;
			}
			while ( uglyNumArr[critical_3]*3 <= nextUglyNum ) {
				critical_3++;
			}
			while ( uglyNumArr[critical_5]*5 <= nextUglyNum ) {
				critical_5++;
			}
			nextUglyNumIndex++;
		}
		return uglyNumArr[index-1];
	}

	private int getMinUglyNum( int a, int b, int c) {
		int min = Integer.MIN_VALUE;
		if ( a < b ) {
			min = a;
		} else {
			min = b;
		}
		if ( min > c ) {
			min = c;
		}
		return min;
	}
	public static void main(String[] args) {
		new Solution().GetUglyNumber_Solution(3);
	}
}