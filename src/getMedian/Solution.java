package getMedian;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	boolean isEven = false;
	// 小顶堆存放数据流中较大的部分，则堆顶是最小元素
	// 让小顶堆元素总是大于等于大顶堆,这样如果一共有奇数个数，直接返回小顶堆堆顶元素即可，反之亦可
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	// 大顶堆存放数据流中较小的部分，则堆顶是最大元素
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
		// PriorityQueue默认是小顶堆，比较器使其变为大顶堆，
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	});

	public void Insert(Integer num) {
		if (isEven) {
			minHeap.offer(num);
			maxHeap.offer(minHeap.poll());
		} else {
			maxHeap.offer(num);
			minHeap.offer(maxHeap.poll());
		}
		isEven = !isEven;
	}

	public Double GetMedian() {
		// Insert中插入结束时会改变isEven的值即使，没有新数据插入
		if (!isEven) {
			return (minHeap.peek() + maxHeap.peek()) / 2.0;
		} else {
			return Double.valueOf(minHeap.peek());
		}
	}

	public static void main(String[] args) {
		int[] num = {5,2,3,4,1,6,7,0,8};
		Solution s = new Solution();
		for (int i = 0; i < num.length; i++) {
			s.Insert(num[i]);
			double avg = s.GetMedian();
			System.out.println(num[i]+":::"+avg);
		}
	}
}