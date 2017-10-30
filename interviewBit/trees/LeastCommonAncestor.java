/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class LeastCommonAncestor {
    
	public int lca(TreeNode a, int val1, int val2) {
	    if (!isAncestorOfTwo(a, val1, val2)) {
	        return -1;
	    } else if (isAncestorOfTwo(a.left, val1, val2)) {
	        if (lca(a.left, val1, val2) != -1) {
	            return lca(a.left, val1, val2);
	        };
	    } else if (isAncestorOfTwo(a.right, val1, val2)) {
	        if (lca(a.right, val1, val2) != -1) {
	            return lca(a.right, val1, val2);
	        };
        }
	  return a.val;  
	}
	
	private boolean isAncestorOfTwo(TreeNode a, int val1, int val2) {
	    return isAncestor(a, val1) && isAncestor(a, val2);
	}
	
	private boolean isAncestor(TreeNode a, int val) {
	    if (a == null) {
	        return false;
	    } else if (a.val == val) {
	        return true;
	    }
	    return (isAncestor(a.left, val) || isAncestor(a.right, val));
	}
}
