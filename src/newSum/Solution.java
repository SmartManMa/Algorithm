package newSum;
public class Solution {
    //求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    public int Sum_Solution(int n) {
    	int sum = n;
    	try {
    		int flag = 1/n;
			sum += Sum_Solution(n-1);
		} catch (Exception e) {
			return 0;
		}
        return sum;
    }
    public static void main(String[] args) {
		
	}
}