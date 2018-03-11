package isSymmetrical;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
    	ArrayList<TreeNode> list1 = new ArrayList<>();
    	ArrayList<TreeNode> list2 = new ArrayList<>();
    	postOrder1(pRoot,list1);
    	postOrder2(pRoot,list2);
    	for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i).val != list2.get(i).val) {
				 return false;
			}
		}
        return true;
    }

	/** 
	  * postOrder2 TODO :
	  * @param pRoot
	  * @param list2
	  * @author zhiman
	  * @date 2018/03/11 ÉÏÎç9:18:14 
	  */
	private void postOrder2(TreeNode pRoot, List<TreeNode> list2) {
		if (pRoot != null) {
			postOrder2(pRoot.right,list2);
			postOrder2(pRoot.left,list2);
			list2.add(pRoot);
		}
	}

	/** 
	  * postOrder1 TODO :
	  * @param pRoot
	  * @param list1
	  * @author zhiman
	  * @date 2018/03/11 ÉÏÎç9:17:58 
	  */
	private void postOrder1(TreeNode pRoot, List<TreeNode> list1) {
		if (pRoot != null) {
			postOrder1(pRoot.left,list1);
			postOrder1(pRoot.right,list1);
			list1.add(pRoot);
		}
	}
}