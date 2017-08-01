/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InorderTraversal {

	public ArrayList<Integer> inorderTraversal(TreeNode a) {
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    helper(a, list);
	    return list;
	}
	
	private void helper(TreeNode a, ArrayList<Integer> list) {
	    if (a == null) {
	        return;
	    }
	    if (a.left != null) {
	        helper(a.left, list);
	    }
	    list.add(a.val);
	    if (a.right != null) {
	        helper(a.right, list);
	    }
	}
	
}
