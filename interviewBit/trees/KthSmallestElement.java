/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class KthSmallestElement {
    
    public int kthsmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        TreeNode current = root;
        int leftNodes = countNodes(current.left);
        int rightNodes = countNodes(current.right);
        if (leftNodes + rightNodes + 1 < k) {
            return -1;
        }
        
        int count = 0;
        while (true) {
            leftNodes = countNodes(current.left);
            if (k == leftNodes + count + 1) {
                return current.val;
            } else if (k > leftNodes + count) {
                current = current.right;
                count += leftNodes + 1;
            } else {
                current = current.left;
            }    
        }
    }
    
    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}
