package isContinuous;

import java.util.Arrays;

//��Ŀ����
//LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,��������,������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13�������5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Ρ�Ϊ�˷������,�������Ϊ��С����0��
public class Solution {
	public boolean isContinuous(int[] numbers) {
		if ( numbers == null || numbers.length == 0) {
			return false;
		}
		Arrays.sort(numbers);
		int zeros = 0;
		int dis = 0;
		for (int i = 0; i < numbers.length; i++) {
			if ( numbers[i] == 0 ) {
				zeros++;
			} else if ( i < numbers.length-1) {
				dis += numbers[i+1] - numbers[i] - 1;
			}
		}
		if ( zeros >= dis && dis >= 0) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		int[] numbers = {0,3,2,6,4};
		System.out.println(new Solution().isContinuous(numbers));
	}
}