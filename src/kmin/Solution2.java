package kmin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		int len = input.length;
		if (input == null || len < k || k <= 0) {
			return result;
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		for (int i = 0; i < input.length; i++) {
			if ( maxHeap.size() < k) {
				maxHeap.offer(input[i]);
			} else if ( input[i] < maxHeap.peek() ){
				maxHeap.poll();
				maxHeap.offer(input[i]);
			}
		}
		result.addAll(maxHeap);
		return result;
		
	}
}