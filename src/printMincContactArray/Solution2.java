package printMincContactArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution2 {
    public String PrintMinNumber(int [] numbers) {
    	ArrayList<String> numlist = new ArrayList<>();
    	for (int i = 0; i < numbers.length; i++) {
			numlist.add( ( (Integer)numbers[i] ).toString() );
		}
    	Collections.sort(numlist, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				String a = str1+str2;
				String b = str2+str1;
				return a.compareTo(b);
			}
		});
    	StringBuilder minNum = new StringBuilder();
    	for ( String str : numlist ) {
    		minNum.append(str);
    	}
    	return minNum.toString();
    }
}