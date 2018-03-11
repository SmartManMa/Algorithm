package reverselist;



public class Solution {
    public static ListNode ReverseList(ListNode head) {
    	if (head == null)
    		return null;
    	if (head.next == null)
    		return head;
    	
    	ListNode rear = head.next;
    	ListNode temp = rear.next;
    	head.next = null;
    	while ( temp != null ) {
    		rear.next =head;
    		head = rear;
    		rear = temp;
    		temp = temp.next;
    	}
    	rear.next =head;
    	return rear;
    }
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	ListNode index =head;
		for (int i = 2; i < 6; i++) {
			index.next = new ListNode(i);
			index = index.next;
		}
		ListNode ll = ReverseList(head);
    }
}