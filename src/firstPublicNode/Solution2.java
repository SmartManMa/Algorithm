package firstPublicNode;

public class Solution2 {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		}
		int len1 = getListlenth(pHead1), len2 = getListlenth(pHead2);
		ListNode firstCommonNode = null;
		if (len1 > len2) {
			ListNode p = move(pHead1, len1 - len2);
			firstCommonNode = getFirstCommonNode(p,pHead2);
		} else  {
			ListNode p = move(pHead2, len2 - len1);
			firstCommonNode = getFirstCommonNode(p,pHead1);
		}
		return firstCommonNode;
	}

	/** 
	  * FindFirstCommonNode TODO :
	  * @param p
	  * @param pHead2
	  * @param i
	  * @return
	  * @author zhiman
	  * @date 2018/03/06 обнГ11:17:23 
	  */
	private ListNode getFirstCommonNode(ListNode p1, ListNode p2) {
		while (!p1.equals(p2) && p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		if ( p1.equals(p2) ) {
			return p1;
		}
		return null;
	}

	/**
	 * move TODO :
	 * 
	 * @param pHead1
	 * @param i
	 * @return
	 * @author zhiman
	 * @date 2018/03/06 обнГ11:07:12
	 */
	private ListNode move(ListNode pHead, int times) {
		ListNode p = pHead;
		for (int i = 0; i < times; i++ ) {
			p = p.next;
		}
		return p;
	}

	/**
	 * getListlenth TODO :
	 * 
	 * @param pHead2
	 * @return
	 * @author zhiman
	 * @date 2018/03/06 обнГ11:00:51
	 */
	private int getListlenth(ListNode pHead) {
		int len = 0;
		for (ListNode p = pHead; p != null;) {
			len++;
			if (p.next == null) {
				break;
			}
			p = p.next;
		}
		return len;
	}
}