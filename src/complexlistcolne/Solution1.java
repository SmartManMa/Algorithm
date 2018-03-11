package complexlistcolne;

public class Solution1 {
	
	public RandomListNode Clone(RandomListNode pHead) {
		RandomListNode mergedList = copyMergeList(pHead);
		RandomListNode randomList = setRandomNode(mergedList);
		RandomListNode copyedList = getClonedList(randomList);
		return copyedList;
	}

	/** 
	  * getClonedList TODO :
	  * @param randomList
	  * @return
	  * @author zhiman
	  * @date 2018/02/08 下午3:10:19 
	  */
	private RandomListNode getClonedList(RandomListNode head) {
		RandomListNode clonedListHead = null;
		if ( head != null && head.next != null) {
			clonedListHead = head.next;
		}
		RandomListNode rear = clonedListHead;
		while (head != null && head.next != null && head.next.next != null) {
			head.next = head.next.next;
			rear.next = rear.next.next;
			head = head.next;
			rear = rear.next; 
		}
		return clonedListHead;
	}

	/**
	 * setRandomNode TODO :
	 * 
	 * @param mergedList
	 * @return
	 * @author zhiman
	 * @date 2018/02/08 下午2:56:50
	 */
	private RandomListNode setRandomNode(RandomListNode head) {

		RandomListNode rear = head;
		while (rear != null) {
			if ( rear.random == null) {
				rear = rear.next;
				continue;
			}
			RandomListNode temp = rear.random;
			rear = rear.next;
			rear.random = temp.next;
			rear = rear.next;
		}
		return head;
	}

	/**
	 * copyMergeList TODO :
	 * 
	 * @param pHead
	 * @return
	 * @author zhiman
	 * @date 2018/02/08 下午2:49:12
	 */
	private RandomListNode copyMergeList(RandomListNode pHead) {
		RandomListNode rear = pHead;
		while (rear != null) {
			RandomListNode temp = rear.next;
			rear.next = new RandomListNode(rear.label);
			rear = rear.next;
			rear.next = temp;
			rear = rear.next;
		}
		return pHead;
	}
	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		RandomListNode node5 = new RandomListNode(5);
		RandomListNode head = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node1.random = node3;
		node2.random = node5;
		node4.random = node2;
		RandomListNode phead = new Solution1().Clone(head);
	}
}