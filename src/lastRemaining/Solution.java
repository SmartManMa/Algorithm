package lastRemaining;
// ½£Ö¸offer 62
import java.util.ArrayList;

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
    	if ( n <= 0 || m <= 0) {
    		return -1;
    	}
    	ArrayList<Integer> arr = new ArrayList<>(n);
    	for (int i = 0; i < n; i++) {
    		arr.add(i);
    	}
    	int k = (m + arr.size() - 1) % arr.size();
    	for (int i = 0; i < n; i++) {
    		if ( arr.size() == 1) {
    			return arr.get(0);
    		}
    		arr.remove(k);
    		k = (k + m + arr.size() - 1) % arr.size();
    	}
        return -1;
    }

	public static void main(String[] args) {
		System.out.println(new Solution().LastRemaining_Solution(5, 0));
	}
}