package strToInt;
public class Solution {
    public int StrToInt(String str) {
    	if (str == null || str.trim().equals("")) {
    		return 0;
    	}
    	char[] ch = str.trim().toCharArray();

    	int result = 0;
    	int i = 0;
    	boolean sign = true;
    	if (ch[i] == '+') {
    		i++;
    	} else if(ch[i] == '-'){
    		sign = false;
    		i++;
    	}
    	for (; i < ch.length; i++) {

			if (ch[i] >= '0' && ch[i] <= '9') {
				result = result * 10 + ch[i] - '0';
			} else {
				return 0;
			}
		}
    	return sign ? result : -1 * result;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().StrToInt("123      "));
	}
}