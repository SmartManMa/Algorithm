package leftRotateString;

public class Solution {
    
    public String LeftRotateString(String str,int n) {
        if ( str == null || str.length() == 0) {
            return str;
        }
    	int npos = n % str.length();
    	if ( npos == 0) {
    		return str;
    	}
    	String str1 = str.substring(0, npos);
    	String str2 = str.substring(npos, str.length());
    	char[] ch = str1.toCharArray();
    	StringBuilder sb = new StringBuilder(str2);
    	sb.append(str1);
    	//System.out.println(str1);
        return sb.toString();
    }
    public static void main(String[] args) {
		String str = "abcXYZdef";
		System.out.println(new Solution().LeftRotateString(str, 39));
	}

}