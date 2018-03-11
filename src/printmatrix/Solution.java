package printmatrix;

import java.util.ArrayList;

public class Solution {
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		ArrayList<Integer> result = new ArrayList<>();
		if ( matrix == null || rows == 0 || cols == 0 ) {
			return null;
		}
		for ( int start = 0; 2*start < rows && 2*start <cols ; start++ ) {
			int endx = cols - start - 1;
			int endy = rows - start - 1;
			// 自左至右打印一行
			for (int i = start; i <= endx; i++) {
				result.add(matrix[start][i]);
				System.out.println(matrix[start][i]);
			}
			// 自上至下打印一列
			if ( start < endy) {
				for (int j = start +1; j <= endy; j++) {
					result.add(matrix[j][endx]);
					System.out.println(matrix[j][endx]);
				}
			}
			// 自右至左打印一行
			if ( start < endy && start < endx ) {
				for (int i = endx - 1; i >= start; i--) {
					result.add(matrix[endy][i]);
					System.out.println(matrix[endy][i]);
				}
			}
			
			// 自下至上打印一列
			if ( start < endy -1 && start < endx) {
				for (int j = endy - 1; j > start; j--) {
					result.add(matrix[j][start]);
					System.out.println(matrix[j][start]);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},
						  {4,5,6},
						  {7,8,9}
		                 };
		new Solution().printMatrix(matrix);
	}
}