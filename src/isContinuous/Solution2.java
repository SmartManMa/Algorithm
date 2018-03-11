package isContinuous;

import java.util.Arrays;

//��Ŀ����
//LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,��������,������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13�������5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Ρ�Ϊ�˷������,�������Ϊ��С����0��
public class Solution2 {
	public boolean isContinuous(int[] numbers) {
		if (numbers.length != 5)
			return false;
		int min = 14;
		int max = -1;
		int flag = 0;
		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i];
			if (number < 0 || number > 13)
				return false;
			if (((flag >> number) & 1) == 1)
				return false;
			flag |= (1 << number);
			if (number > max)
				max = number;
			if (number < min)
				min = number;
			if (max - min >= 5)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] numbers = { 0, 3, 2, 6, 4 };
		System.out.println(new Solution2().isContinuous(numbers));
	}
}