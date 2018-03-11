package mergelist;

public class Solution {
	public ListNode Merge(ListNode list1, ListNode list2) {
		if ( list1 == null ||  list2 == null ) {
			return (list1 == null) ? list2 : list1;
		}
		ListNode head = null;
		if ( list1.val <= list2.val ) {
			head = list1;
			list1 = list1.next;
		} else {
			head = list2;
			list2 = list2.next;
		}
		ListNode rear = head;
		while (list1 != null && list2 != null) {
			if ( list1.val <= list2.val ) {
				rear.next = list1;
				list1 = list1.next;
			} else {
				rear.next = list2;
				list2 = list2.next;
			}
			rear = rear.next;
		}
		if ( list1 != null ) {
			rear.next = list1;
		}
		if ( list2 != null ) {
			rear.next = list2;
		}	 
		return head;
	}
	// µÝ¹é°æ±¾
    public ListNode Merge(ListNode list1,ListNode list2,boolean isRec) {
		if ( list1 == null ||  list2 == null ) {
			return (list1 == null) ? list2 : list1;
		}
        ListNode head = null;
        if ( list1.val <= list2.val ) {
            head = list1;
            head.next = Merge( list1.next, list2 );
        } else {
            head = list2;
            head.next = Merge( list1, list2.next );
        }
        return head;
    }
}