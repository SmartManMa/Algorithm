package reorderarray;
public class Solution {
    public void reOrderArray(int [] array) {
        int odd = 0;
        int even = 0;
        int len = array.length;
        while (even < len && odd < len) {
        	// ��ǰ�����ҵ���һ��ż��
        	for (;even < len && ( array[even] & 1 ) ==1  ; even++);
        	// �ҵ���һ��ż����ĵ�һ������
        	odd = even + 1;
        	for (;odd < len && (array[odd] & 1) ==0  ; odd++);
        	// ��λ����
        	if ( odd >= len ) {
        		break;
        	}
        	int temp = array[odd];
        	while( even < odd && odd < len) {
        		array[odd] = array[odd - 1];
        		odd--;
        	}
        	array[even] = temp;
        	even++;
        }
    }
    public static void main(String[] args) {
    	int [] array = {1};
    	new Solution().reOrderArray(array);
    	for (int i = 0; i < array.length; i++) {
			System.out.println(i+":::"+array[i]);
		}
	}
}