package findContinuousSequence;

import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<Integer> ContinuousSeq = null;
		ArrayList<ArrayList<Integer>> allSeq = new ArrayList<>();
		// 如果low > sum的一半，意味着没有更多的序列满足条件了
		int endFlag = (sum >> 1) + 1;
		int seqSum = 1 + 2;
		for (int low = 1, high = 2; low <= endFlag && low < high;) {
			if (seqSum < sum) {
				seqSum += ++high;
			}
			if (seqSum > sum) {
				seqSum -= low;
				low++;
			}
			if (seqSum == sum) {
				ContinuousSeq = new ArrayList<>();
				for (int i = low; i <= high; i++) {
					ContinuousSeq.add(i);
				}
				allSeq.add(ContinuousSeq);
				seqSum -= low;
				low++;
			}
		}
		return allSeq;
	}

//	public static void main(String[] args) {
//		ArrayList<ArrayList<Integer>> list = new Solution().FindContinuousSequence(100);
//		int i = 1;
//		for (ArrayList<Integer> arr : list) {
//			System.out.println(i++ + ":");
//			for (Integer a : arr) {
//				System.out.print(a + "+");
//			}
//			System.out.println();
//		}
//	}
}