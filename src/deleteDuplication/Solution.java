package deleteDuplication;

/* ��һ������������У������ظ��Ľ�㣬
 * ��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
 * ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
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
		ListNode first = new ListNode(-1);//����һ��trick
		ListNode p = pHead;
		ListNode last = first;
		while (p != null && p.next != null) {
			if (p.val == p.next.val) {
				int val = p.val;
				while ( p != null  && p.val == val) {
					p = p.next;
				}
				// �����������������ͷ�������1,1,1,3,4,4,4,5
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