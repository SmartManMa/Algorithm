package regex;

/*请实现一个函数用来匹配包括'.'和'*'的正则表达式。
模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 
在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
*/

public class Solution {
	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		}
		return matchCore(str, 0, pattern, 0);
	}

	/**
	 * matchCore TODO :
	 * 
	 * @param str
	 * @param i
	 * @param pattern
	 * @param j
	 * @return
	 * @author zhiman
	 * @date 2018/03/10 下午7:01:16
	 */
	private boolean matchCore(char[] str, int strIndex, char[] pat, int patIndex) {
		int strlen = str.length;
		int patlen = pat.length;
		// 字符串和模式串都匹配到末尾，返回true
		if (strIndex == strlen && patIndex == patlen) {
			return true;
		}
		// 模式串匹配到末尾，而字符串没有匹配到末尾，返回false
		if (strIndex < strlen && patIndex == patlen) {
			return false;
		}
		// 模式串没匹配到末尾，而字符串匹配到末尾，则结果不一定，因为 a*可被忽略
		//首先判断a后面是不是*
		if (patIndex + 1 < patlen && pat[patIndex + 1] == '*') {
			
			if ( 	   // 第一个字符相等
					   ( strIndex != strlen && pat[patIndex] == str[strIndex] ) 
					   // 或者模式第一个字符为‘.’
					|| ( pat[patIndex] == '.' && strIndex != strlen ) 
				) {
				return  //字符串第一个字符与模式串相等，例：str = “abc” pattern = "a*bc"
						matchCore(str, strIndex+1, pat, patIndex+2)
						//字符串第一个字符与模式串相等，例：str = “aabc” pattern = "a*bc"
					||  matchCore(str, strIndex+1, pat, patIndex)
					    //字符串第一个字符与模式串相等，例：str = “bc” pattern = ".*bc"
					||  matchCore(str, strIndex, pat, patIndex+2);
			} else {
				// 否则 pattern = "a*bc" 跳过a*
				return matchCore(str, strIndex, pat, patIndex+2);
			}
		}
		//a后面不是* 模式和字符串同时后移一位
		if ( 	   // 第一个字符相等
				   ( strIndex != strlen && pat[patIndex] == str[strIndex] ) 
				   // 或者模式第一个字符为‘.’
				|| ( pat[patIndex] == '.' && strIndex != strlen ) 
			) {
			return matchCore(str, strIndex+1, pat, patIndex+1);
		}
		return false;
	}

}
