package serialize;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
	public static void main(String[] args) {
		String str = "8,6,10,5,7,9,11";
		new Solution().Deserialize(str);
	}

	String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val + ",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}

	TreeNode Deserialize(String str) {
		String[] tree = str.split(",");
		LinkedList<String> queue = new LinkedList<>(Arrays.asList(tree));
		return DeserializeCore(queue);
	}

	/** 
	  * DeserializeCore TODO :
	  * @param queue
	  * @return
	  * @author zhiman
	  * @date 2018/03/11 下午3:50:13 
	  */
	private TreeNode DeserializeCore(LinkedList<String> queue) {
		String rootStr = queue.removeFirst();
		if ( "#".equals(rootStr) ) {
			// 根节点为空，则返回空
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(rootStr));
		root.left = DeserializeCore(queue);
		root.right = DeserializeCore(queue);
		return root;
	}

}