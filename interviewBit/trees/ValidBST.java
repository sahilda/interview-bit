/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidBST {
	
	public int isValidBST(TreeNode a) {
	    if (a == null) {
	        return 1;
	    }
	    
	    if (isSubtreeLesser(a.left, a.val) == 1 && 
	        isSubtreeGreater(a.right, a.val) == 1 &&
	        isValidBST(a.left) == 1 &&
	        isValidBST(a.right) == 1) {
	            return 1;
	        }
	    return 0;
	}
	
	private int isSubtreeLesser(TreeNode a, int val) {
	    if (a == null) {
	        return 1;
	    }
	    if (a.val < val && isSubtreeLesser(a.left, val) == 1 && isSubtreeLesser(a.right, val) == 1) {
	        return 1;
	    }
	    return 0;
	}
	
	private int isSubtreeGreater(TreeNode a, int val) {
	    if (a == null) {
	        return 1;
	    }
	    if (a.val > val && isSubtreeGreater(a.left, val) == 1 && isSubtreeGreater(a.right, val) == 1) {
	        return 1;
	    }
	    return 0;
	}

	public int isValidBSTV2(TreeNode a) {
	    return isValidBSTBetter(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public int isValidBSTBetter(TreeNode a, int min, int max) {
		if (a == null) {
			return 1;
		}

		if (a.val > min && a.val < max && isValidBSTBetter(a.left, min, a.val) == 1 && 
			isValidBSTBetter(a.right, a.val, max) == 1) {
			return 1;
		}

		return 0;
	}
	
}
