package findNumsAppearOnce;

import java.util.ArrayList;

public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int result = 0;
    	for (int i = 0 ;i < array.length; i++) {
        	result ^= array[i];
        }
    	int bin = 1;
    	for (int i =0; i < 32 && (result & bin) == 0; i++) {
    		bin = 1<<bin;
    	}
    	ArrayList<Integer> one = new ArrayList<>();
    	ArrayList<Integer> nonone = new ArrayList<>();
    	for (int i = 0 ; i < array.length; i++) {
        	if ( (bin & array[i]) == 0) {
        		nonone.add(array[i]);
        	} else {
        		one.add(array[i]);
        	}
        }
    	num1[0] = 0;
    	num2[0] = 0;
    	for (Integer i : one) {
    		num1[0] ^= i;
    	}
    	for (Integer i : nonone) {
    		num2[0] ^= i;
    	}
    }
    public static void main(String[] args) {
    	int [] array = {2,4,3,6,3,2,5,5};
    	int num1[] = new int[1];
    	int num2[] = new int[1];
    	new Solution().FindNumsAppearOnce(array, num1, num2);
    	System.out.println(num1[0] + "--" + num2[0]);
	}
}