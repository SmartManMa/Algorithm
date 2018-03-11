package BinarySearchTree;
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if ( sequence == null || sequence.length == 0 ) {
            return false;
        }
        int len = sequence.length;
        if ( len == 1 || len == 2 )
        	return true;
        int rootVal = sequence[len-1];
        // key:rightTreeStart  = len - 1
        int rightTreeStart  = len - 1;
        for ( int i = 0; i < len - 1;i++ ) { 
        	if ( sequence[i] > rootVal ) {
        		rightTreeStart = i;
        		break;
        	}
        }
        
        for ( int j = rightTreeStart; j < len - 1; j++ ) {
        	if ( sequence[j] < rootVal ) {
        		return false;
        	}
        }
        boolean left = true;
        if ( rightTreeStart > 0 ) {
        	int[] leftTree = new int[rightTreeStart];
            System.arraycopy(sequence, 0, leftTree, 0, leftTree.length);
            left = VerifySquenceOfBST(leftTree);
        }
        boolean right = true;
        if ( rightTreeStart < len - 1 ) {
        	int[] rightTree = new int[len - rightTreeStart - 1];
            System.arraycopy(sequence, rightTreeStart, rightTree, 0, rightTree.length);
            right = VerifySquenceOfBST(rightTree);
        }
        
        return left && right; 
    }
    
    // 排行第一的代码
    public boolean VerifySquenceOfBST111(int [] sequence) {
        if(sequence.length == 0) return false;
        return IsTreeBST(sequence, 0, sequence.length-1);
    }
    public boolean IsTreeBST(int [] sequence,int start,int end ){
        if(end <= start) return true;
        int i = start;
        for (; i < end; i++) {
            if(sequence[i] > sequence[end]) break;
        }
        for (int j = i; j < end; j++) {
            if(sequence[j] < sequence[end]) return false;
        }
        return IsTreeBST(sequence, start, i-1) && IsTreeBST(sequence, i, end-1);
    }
    public static void main(String[] args) {
		int[] seq = {7,4,6,5,9};
		System.out.println(new Solution().VerifySquenceOfBST111(seq));
	}
}