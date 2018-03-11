package minstack;
import java.util.Stack;

public class Solution {
	private Stack<Integer> dataStack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
    	dataStack.push(node);
    	if ( minStack.size() == 0 || node < minStack.peek() ) {
    		minStack.push(node);
    	} else {
    		minStack.push( minStack.peek() );
    	}
    }
    
    public void pop() {
    	dataStack.pop();
    	minStack.pop();
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int min() {
    	return minStack.peek();
    }
}