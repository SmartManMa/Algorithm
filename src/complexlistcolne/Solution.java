package complexlistcolne;
public class Solution {
	public RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null)
			return null;
		RandomListNode pCur = pHead;
		// 复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
		while (pCur != null) {
			RandomListNode node = new RandomListNode(pCur.label);
			node.next = pCur.next;
			pCur.next = node;
			pCur = node.next;
		}
		pCur = pHead;
		// 复制random pCur是原来链表的结点 pCur.next是复制pCur的结点
		while (pCur != null) {
			if (pCur.random != null)
				pCur.next.random = pCur.random.next;
			pCur = pCur.next.next;
		}
		RandomListNode head = pHead.next;
		RandomListNode cur = head;
		pCur = pHead;
		// 拆分链表
		while (pCur != null) {
			pCur.next = pCur.next.next;
			if (cur.next != null)
				cur.next = cur.next.next;
			cur = cur.next;
			pCur = pCur.next;
		}
		return head;
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
		RandomListNode phead = new Solution().Clone(head);
	}
}
