package maxWindows;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>( new Comparator<Integer>() {
			// PriorityQueue默认是小顶堆，比较器使其变为大顶堆，
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		ArrayList<Integer> res = new ArrayList<>();
		if( num == null || size <= 0 || num.length < size) {
			return res;
		}
		for (int i = 0; i < num.length; i++) {
			if(maxHeap.size() < size) {
				maxHeap.offer(num[i]);
			} else {
				res.add(maxHeap.peek());
				maxHeap.remove(num[i-size]);
				maxHeap.offer(num[i]);
			}
		}
		res.add(maxHeap.peek());
		return res;
	}
}