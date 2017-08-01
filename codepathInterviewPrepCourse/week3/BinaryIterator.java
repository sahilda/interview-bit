Implement an iterator for a binary search tree

class TreeNode {
	
	public TreeNode left;
	public TreeNode right;
	public int val;

	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

}

class BinaryIterator implements Iterator {

	TreeNode current;
	Stack<TreeNode> parents;
	
	public BinaryIterator(TreeNode root) {
		parents = new Stack<>();
		current = traverseToSmallest(root);
	}

	public boolean hasNext() {
		if (current == null) {
			return false;
		} else {
			return true;
		}

	}

	public TreeNode next() {
		TreeNode value = current;
		if (value.right != null) {
			current = traveseToSmallest(value.right);
		} else {
			current = stack.pop();
		}		
		return value;
	}

	public TreeNode traverseToSmallest(TreeNode node) {
		if (node == null) {
			return null;
		}

		TreeNode result = node;
		while (result.left != null) {
			stack.push(result);
			result = result.left;
		}
		return result;
	}


}