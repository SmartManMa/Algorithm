package printMincContactArray;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
    	StringBuilder minNumber = new StringBuilder();
    	for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j < numbers.length;j++) {
				String a = numbers[i]+""+numbers[j];
				String b = numbers[j]+""+numbers[i];
				if ( a.compareTo(b) > 0) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
    	for (int num:numbers) {
    		minNumber.append(num);
    	}
    	return minNumber.toString();
    }
}