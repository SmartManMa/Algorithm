package fibonacci;
public class Solution2 {
    public int Fibonacci(int n) {
    	int[] result = {0,1};
    	if ( n <= 1) {
    		return result[n];
    	}
    	int fib1 = 1;
    	int fib2 = 0;
    	int fibn = 0;
    	for (int i = 2; i <= n; i++) {
			fibn = fib1 + fib2;
			fib2 = fib1;
			fib1 = fibn;
		}
    	return fibn;
    	
    }
    public static void main(String[] args) {
		System.out.println(new Solution2().Fibonacci(39));
	}
}