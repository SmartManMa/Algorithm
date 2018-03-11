package getMedian;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	boolean isEven = false;
	// С���Ѵ���������нϴ�Ĳ��֣���Ѷ�����СԪ��
	// ��С����Ԫ�����Ǵ��ڵ��ڴ󶥶�,�������һ��������������ֱ�ӷ���С���ѶѶ�Ԫ�ؼ��ɣ���֮���
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	// �󶥶Ѵ���������н�С�Ĳ��֣���Ѷ������Ԫ��
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
		// PriorityQueueĬ����С���ѣ��Ƚ���ʹ���Ϊ�󶥶ѣ�
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
		// Insert�в������ʱ��ı�isEven��ֵ��ʹ��û�������ݲ���
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