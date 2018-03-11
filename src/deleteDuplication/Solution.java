package deleteDuplication;

/* 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 
 * */
public class Solution {
	public ListNode deleteDuplication(ListNode pHead) {
		if ( pHead == null ) {
			return null;
		}
		if ( pHead .next == null) {
			return pHead;
		}
		//{1,2,3,3,4,4,5}
		ListNode first = new ListNode(-1);//设置一个trick
		ListNode p = pHead;
		ListNode last = first;
		while (p != null && p.next != null) {
			if (p.val == p.next.val) {
				int val = p.val;
				while ( p != null  && p.val == val) {
					p = p.next;
				}
				// 解决了类似这样序列头结点问题1,1,1,3,4,4,4,5
				last.next = p;
			} else {
				last.next = p;
				last = last.next;
				p = p.next;
			}
		}
		return first.next;
	}
}