package sumNew;
public class Solution {
    public int Add(int num1,int num2) {
    	if ( num1  == 0 || num2 == 0) {
    		return num1 == 0 ? num2 : num1;
    	}
    	// 不进位
    	int result1 = num1 ^ num2;
    	// 进位
    	int result2 = num1 & num2;
    	if ( result2 == 0) {
    		//进位为0,则返回
    		return result1;
    	} else {
    		//进位不为0,递归
    		return Add(result1,result2<<1);
    	}
    }
//    public static void main(String[] args) {
//		System.out.println(new Solution().Add(10, 1000));
//	}
}