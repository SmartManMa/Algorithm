package matrixPath;

class SolutionMethod1 {
	public int movingCount(int threshold, int rows, int cols) {
		boolean[] visted = new boolean[rows * cols];
		for (int i = 0; i < visted.length; i++)
			visted[i] = false;

		int count = movingCountCore(threshold, rows, cols, 0, 0, visted);
		return count;
	}

	/*
	 * �ݹ���ݷ�����
	 * 
	 * @param threshold Լ��ֵ
	 * 
	 * @param rows ��������
	 * 
	 * @param cols ��������
	 * 
	 * @param row ��ǰ������к�
	 * 
	 * @param col ��ǰ������к�
	 * 
	 * @param visted ���ʱ������
	 * 
	 * @return �����ߵķ���
	 */
	public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visted) {
		int count = 0;
		if (check(threshold, rows, cols, row, col, visted)) {
			visted[row * cols + col] = true;

			count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visted)
					+ movingCountCore(threshold, rows, cols, row, col - 1, visted)
					+ movingCountCore(threshold, rows, cols, row + 1, col, visted)
					+ movingCountCore(threshold, rows, cols, row, col + 1, visted);
		}
		return count;
	}

	boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visted) {
		if (row >= 0 && row < rows && col >= 0 && col < cols && (getDigitSum(row) + getDigitSum(col) <= threshold)
				&& !visted[row * cols + col])
			return true;
		return false;
	}

	/*
	 * һ�����ֵ�λ��֮��
	 * 
	 * @param number ����
	 * 
	 * @return ���ֵ�λ��֮��
	 */
	public int getDigitSum(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}
}