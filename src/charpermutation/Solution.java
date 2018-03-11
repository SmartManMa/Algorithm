package charpermutation;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> perList = new ArrayList<>();
		char[] ch = str.toCharArray();
		getPermutation(ch, 0, perList);
		Collections.sort(perList);
		return perList;
	}

	/**
	 * getPermutation TODO :
	 * @param str
	 * @param strBegin
	 * @param perList
	 * @author zhiman
	 * @date 2018/02/25 下午7:27:13
	 */
	private void getPermutation(char[] ch, int strBegin, ArrayList<String> perList) {
		if (ch == null) {
			return;
		}
		if (strBegin == ch.length - 1) {
			String s = String.valueOf(ch);
			if (!perList.contains(s)) {
				perList.add(s);
			}
		}
		for (int i = strBegin; i < ch.length; i++) {
			// 交换
			char temp = ch[i];
			ch[i] = ch[strBegin];
			ch[strBegin] = temp;
			
			getPermutation(ch, strBegin + 1, perList);
			// 恢复原样
			temp = ch[i];
			ch[i] = ch[strBegin];
			ch[strBegin] = temp;
		}
	}

}