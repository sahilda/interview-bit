/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class IdenticalBinaryTrees {

	public int isSameTree(TreeNode a, TreeNode b) {
	    if (a == null && b == null) {
	        return 1;
	    }
	    ArrayList<Integer> aList = new ArrayList<>();
	    ArrayList<Integer> bList = new ArrayList<>();
	    helper(a, aList);
	    helper(b, bList);
	    
	    return (aList.equals(bList)) ? 1 : 0;
	}
	
	private void helper(TreeNode a, ArrayList<Integer> list) {
	    if (a == null) {
	        return;
	    }
	    helper(a.left, list);
	    list.add(a.val);
	    helper(a.right, list);
	}
}
