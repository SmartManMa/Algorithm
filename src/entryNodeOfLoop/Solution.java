package entryNodeOfLoop;

import java.util.HashSet;

public class Solution {

	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		ListNode p = pHead;
		HashSet<ListNode> set = new HashSet<>();
		while (set.add(p)) {
			if (p.next != null) {
				p = p.next;
			} else {
				return null;
			}
		}
		return p;
	}
}