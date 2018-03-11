package leftRotateString;

public class Solution2 {
    
    public String LeftRotateString(String str,int n) {
        if ( str == null || str.length() == 0) {
            return str;
        }
        int len = str.length();
    	int npos = n % len;
    	if ( npos == 0) {
    		return str;
    	}
    	String str1 = str + str;
    	
    	System.out.println(str1+len+str1.length());
        return str1.substring(npos, npos+len);
    }
    public static void main(String[] args) {
		String str = "abcdefg";
		str = new Solution2().LeftRotateString(str, 2);
		System.out.println(str);
	}

}