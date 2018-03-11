package regex;

public class Solution2 {
	public boolean match(char[] str, char[] pattern) {
		boolean flag = false;
		if (str.length == pattern.length) {
			for (int i = 0; i < pattern.length; i++) {
				if ( str[i] != pattern[i] && str[i] == '.') {
					continue;
				} else if(str[i] != pattern[i] && str[i] == '*' && str[i] == pattern[i-1]) {
					continue;
				}
			}
			return false;
		} else  if ( str.length == pattern.length ){
			
		}
		return false;
	}
}