package newSum;
public class Solution {
    //��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
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