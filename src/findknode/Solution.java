package findknode;
public class Solution {
    public static ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<=0){
            return null;
        }
        ListNode knode = head;
        ListNode rear = head;
        int count = 0;
		for ( ;rear.next != null;) {
            rear = rear.next;
            count++;
            if ( count < k )
                continue;
            knode = knode.next;
        }
        if (count < k-1)
            return null;
        return knode;
    }
    public static void main(String[] args) {
    	ListNode head = new ListNode(0);
    	ListNode index =head;
		for (int i = 1; i < 3; i++) {
			index.next = new ListNode(i);
			index = index.next;
		}
		
		ListNode ll = FindKthToTail(head,3);
		System.out.println(ll.val);
	}
}