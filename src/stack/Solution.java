package stack;

import java.util.Stack;

public class Solution {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if ( stack2.empty() ) {
			while ( !stack1.empty() ) {
				int temp = stack1.pop();
				stack2.push(temp);
			}
		}
		return stack2.pop();
	}

	public static void main(String[] args) {
		int[] testArr = { 8, 4, 3, 6, 7, 3, 2, 1, 9, 4, 3 };
		Solution ss = new Solution();
		for (int i = 0; i < 4; i++) {
			ss.push(testArr[i]);
		}
		for (int i = 0; i < 4; i++) {
			System.out.println("**" + ss.pop());
		}
		for (int i = 4; i < 8; i++) {
			ss.push(testArr[i]);
		}
		for (int i = 4; i < 8; i++) {
			System.out.println("**" + ss.pop());
		}
	}
}