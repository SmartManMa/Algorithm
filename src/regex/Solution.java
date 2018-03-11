package regex;

/*��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��
ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ��� 
�ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
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
	 * @date 2018/03/10 ����7:01:16
	 */
	private boolean matchCore(char[] str, int strIndex, char[] pat, int patIndex) {
		int strlen = str.length;
		int patlen = pat.length;
		// �ַ�����ģʽ����ƥ�䵽ĩβ������true
		if (strIndex == strlen && patIndex == patlen) {
			return true;
		}
		// ģʽ��ƥ�䵽ĩβ�����ַ���û��ƥ�䵽ĩβ������false
		if (strIndex < strlen && patIndex == patlen) {
			return false;
		}
		// ģʽ��ûƥ�䵽ĩβ�����ַ���ƥ�䵽ĩβ��������һ������Ϊ a*�ɱ�����
		//�����ж�a�����ǲ���*
		if (patIndex + 1 < patlen && pat[patIndex + 1] == '*') {
			
			if ( 	   // ��һ���ַ����
					   ( strIndex != strlen && pat[patIndex] == str[strIndex] ) 
					   // ����ģʽ��һ���ַ�Ϊ��.��
					|| ( pat[patIndex] == '.' && strIndex != strlen ) 
				) {
				return  //�ַ�����һ���ַ���ģʽ����ȣ�����str = ��abc�� pattern = "a*bc"
						matchCore(str, strIndex+1, pat, patIndex+2)
						//�ַ�����һ���ַ���ģʽ����ȣ�����str = ��aabc�� pattern = "a*bc"
					||  matchCore(str, strIndex+1, pat, patIndex)
					    //�ַ�����һ���ַ���ģʽ����ȣ�����str = ��bc�� pattern = ".*bc"
					||  matchCore(str, strIndex, pat, patIndex+2);
			} else {
				// ���� pattern = "a*bc" ����a*
				return matchCore(str, strIndex, pat, patIndex+2);
			}
		}
		//a���治��* ģʽ���ַ���ͬʱ����һλ
		if ( 	   // ��һ���ַ����
				   ( strIndex != strlen && pat[patIndex] == str[strIndex] ) 
				   // ����ģʽ��һ���ַ�Ϊ��.��
				|| ( pat[patIndex] == '.' && strIndex != strlen ) 
			) {
			return matchCore(str, strIndex+1, pat, patIndex+1);
		}
		return false;
	}

}
