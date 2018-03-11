package matrixPath;

public class MatrixPath {
	/**
	 * @param matrix
	 *            ¾ØÕó×Ö·û´®
	 * @param rows
	 *            ¾ØÕóĞĞ
	 * @param cols
	 *            ¾ØÕóÁĞ
	 * @param str
	 *            ×Ö·û´®Â·¾¶
	 * @return ´æÔÚÒ»ÌõÂ·¾¶·µ»Øtrue£¬·ñÔòfalse
	 */
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		boolean flag[] = new boolean[matrix.length];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (helper(matrix, rows, cols, i, j, str, 0, flag))
					return true;
			}
		}
		return false;
	}

	private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, boolean[] flag) {
		int index = i * cols + j;
		if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index])
			return false;
		if (k == str.length - 1)
			return true;
		flag[index] = true;
		if (	   helper(matrix, rows, cols, i - 1, j, str, k + 1, flag) // up
				|| helper(matrix, rows, cols, i + 1, j, str, k + 1, flag) // down
				|| helper(matrix, rows, cols, i, j - 1, str, k + 1, flag) // left
				|| helper(matrix, rows, cols, i, j + 1, str, k + 1, flag) // right
				) {
			return true;
		}
		flag[index] = false;
		return false;
	}
}