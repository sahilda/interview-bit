/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {
    
	public int isBalanced(TreeNode a) {
	    if (nodeBalanced(a)) {
	        return 1;
	    }
	    return 0;
	}
	
	private boolean nodeBalanced(TreeNode a) {
	    if (a == null) {
	        return true;
	    }
	    int left = maxDepth(a.left);
	    int right = maxDepth(a.right);
	    if (Math.abs(left - right) > 1) {
	        return false;
	    }
	    return (nodeBalanced(a.left) && nodeBalanced(a.right));
	}
	
	private int minDepth(TreeNode a) {
	    if (a == null) {
	        return 0;
	    }
	    int left = 1 + minDepth(a.left);
	    int right = 1 + minDepth(a.right);
	    return Math.min(left, right);
	}
	
	private int maxDepth(TreeNode a) {
	    if (a == null) {
	        return 0;
	    }
	    int left = 1 + maxDepth(a.left);
	    int right = 1 + maxDepth(a.right);
	    return Math.max(left, right);
	}
	
}
