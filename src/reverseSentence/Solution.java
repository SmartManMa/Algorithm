package reverseSentence;

import java.util.regex.Pattern;

public class Solution {
    public String ReverseSentence(String str) {
    	if (str == null ) {
    		return str;
    	}
    	Pattern pattern = Pattern.compile("\\s+");
    	String[] ss = pattern.split(str);
    	if ( ss.length == 0 ) {
    		return str;
    	}
    	StringBuilder sb = new StringBuilder();
    	for (int i =ss.length - 1; i >= 0; i--) {
			sb.append(ss[i]);
			if ( i > 0) {
				sb.append(" ");
			}
		}
        return sb.toString();
    }
//    public static void main(String[] args) {
//		String str = "1 2 3 4 5 6 7 8 9";
//		str = new Solution().ReverseSentence(str);
//		System.out.println(str);
//	}
}