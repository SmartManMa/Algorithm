package fibonacci;
public class Solution {
    public int Fibonacci(int n) {
    	if (n == 1 || n == 2) {
    		return 1;
    	}
    	return Fibonacci(n-1) + Fibonacci(n-2);
    }
    public static void main(String[] args) {
		System.out.println(new Solution().Fibonacci(3));
	}
}