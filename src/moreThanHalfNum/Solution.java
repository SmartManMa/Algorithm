package moreThanHalfNum;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
    	if ( array == null) {
    		return 0;
    	}
    	TreeMap<Integer, Integer> count = new TreeMap<>();
    	for ( int i = 0; i < array.length ; i++ ) {
    		int key = array[i];
    		if ( count.get(key) == null ) {
    			count.put(key, 1);
    		} else {
    			int val = count.get(key).intValue();
    			val++;
    			count.put(key,val);
    		}
    	}
    	Set<Map.Entry<Integer, Integer>> entry = count.entrySet();
    	Map.Entry<Integer, Integer> maxEntry = null;
    	for (Map.Entry<Integer, Integer> en : entry) {
    		int maxTimes = 0;
    		if ( maxEntry != null ) {
    			maxTimes = maxEntry.getValue();
    		}
    		maxEntry = en.getValue() <= maxTimes ? maxEntry : en;
    	}
    	if ( maxEntry.getValue() > (array.length/2)) {
    		return maxEntry.getKey();
    	}
        return 0;
    }
    public static void main(String[] args) {
		
	}
}