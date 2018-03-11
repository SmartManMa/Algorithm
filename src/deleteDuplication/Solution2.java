package deleteDuplication;

/* ��һ������������У������ظ��Ľ�㣬
 * ��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
 * ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 * ʹ�õݹ�ķ���
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