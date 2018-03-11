package deleteDuplication;

/* 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 使用递归的方法
 * */
public class Solution2 {
	public ListNode deleteDuplication(ListNode pHead) {
		if ( pHead == null || pHead .next == null) {
			return pHead;
		}
		//{1,2,3,3,4,4,5}
		if ( pHead.val == pHead.next.val ) {
			ListNode p = pHead;
			while ( p != null && p.val == pHead.val ) {
				p = p.next;
			}
			return deleteDuplication(p);
		} else {
			pHead.next = deleteDuplication(pHead.next);
			return pHead;
		}
	}
}