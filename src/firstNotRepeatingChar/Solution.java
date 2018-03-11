package firstNotRepeatingChar;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
	public int FirstNotRepeatingChar(String str) {
		if ( str == null || str.length() == 0) {
			return -1;
		}
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char key = str.charAt(i);
			if ( map.containsKey( key ) ) {
				int value = map.get(key) + 1;
				map.put( key, value );
			} else {
				map.put( key, 1 );
			}
		}
		Set<Map.Entry<Character, Integer>> set = map.entrySet();
		if ( !map.containsValue(1)) {
			return -1;
		}
		for ( Map.Entry<Character, Integer> entry : set) {
			if ( entry.getValue() == 1 ) {
				return str.indexOf(entry.getKey());
			}
		}
		return -1;
	}
}