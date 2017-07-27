/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class NextGreaterNumberBST {

	public TreeNode getSuccessor(TreeNode a, int b) {
	    TreeNode cur = a;
	    while (cur.val != b) {
	        if (b < cur.val) {
	            cur = cur.left;
	        } else {
	            cur = cur.right;
	        }
	    }
	    
	    if (cur.right != null) {
	        return getMin(cur.right);
	    } else {
	        TreeNode successor = null;
	        TreeNode ancestor = a;
	        while (ancestor != cur) {
	            if (cur.val < ancestor.val) {
	                successor = ancestor;
	                ancestor = ancestor.left;
	            } else {
	                ancestor = ancestor.right;
	            }
	        }
	        return successor;
	    }
	}
	
	private TreeNode getMin(TreeNode a) {
	    if (a == null) {
	        return  null;
	    }
	    while (a.left != null) {
	        a = a.left;
	    }
	    return a;
	}

}
