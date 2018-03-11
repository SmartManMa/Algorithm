package firstAppearingOnce;

import java.util.LinkedHashSet;

public class Solution {
    //Insert one char from stringstream
    StringBuilder sb = new StringBuilder();
    public void Insert(char ch)
    {
        sb.append(ch);
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	char[] ch = sb.toString().toCharArray();
    	LinkedHashSet<Character> set = new LinkedHashSet<>();
    	for (int i = 0; i < ch.length; i++) {
			boolean flag = set.add(ch[i]);
			if ( flag == false ) {
				set.remove(ch[i]);
			}
		}
    	if (set.size() > 0) {
    		for(Character c : set) {
    			return c;
    		}
    	}
    	return '#';
    }
}