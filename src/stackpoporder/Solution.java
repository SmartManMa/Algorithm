package stackpoporder;

import java.util.Stack;

public class Solution {
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		Stack<Integer> stack = new Stack<>();
		int pulen = pushA.length;
		int polen = popA.length;
		if (pulen != polen) {
			return false;
		}
		int i = 0, j = 0;
		for (; i < polen; i++) {
			if ( stack.isEmpty() && j < pulen) {
				stack.push( pushA[j] );
				j++;
			}
			while ( j < pulen && stack.peek() != popA[i] ) {
				stack.push( pushA[j] );
				j++;
			}
			if ( stack.peek() == popA[i] ) {
				stack.pop();
			}
		}
		if ( stack.isEmpty() && i == 5)
			return true;
		return false;
	}
}