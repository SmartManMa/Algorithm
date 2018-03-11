package bintreemirror;
public class Solution {
    public void Mirror(TreeNode root) {
        if ( root == null ) {
        	return;
        }
        if ( root.left != null || root.right != null ) {
        	TreeNode tempNode = root.left;
        	root.left = root.right;
        	root.right = tempNode;
        }
        Mirror(root.left);
        Mirror(root.right);
    }
}