package sumNew;
public class Solution {
    public int Add(int num1,int num2) {
    	if ( num1  == 0 || num2 == 0) {
    		return num1 == 0 ? num2 : num1;
    	}
    	// ����λ
    	int result1 = num1 ^ num2;
    	// ��λ
    	int result2 = num1 & num2;
    	if ( result2 == 0) {
    		//��λΪ0,�򷵻�
    		return result1;
    	} else {
    		//��λ��Ϊ0,�ݹ�
    		return Add(result1,result2<<1);
    	}
    }
//    public static void main(String[] args) {
//		System.out.println(new Solution().Add(10, 1000));
//	}
}