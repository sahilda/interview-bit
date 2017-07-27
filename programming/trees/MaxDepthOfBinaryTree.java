/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaxDepthOfBinaryTree {
    
	public int maxDepth(TreeNode a) {
	    if (a == null) {
	        return 0;
	    }
	    int depthLeft = 1;
	    int depthRight = 1;
	    if (a.left != null) {
	        depthLeft += maxDepth(a.left);
	    }
	    if (a.right != null) {
	        depthRight += maxDepth(a.right);
	    }
	    return Math.max(depthLeft, depthRight);
	}
	
}
