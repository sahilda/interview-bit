/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class InvertBinaryTree {
    
    public TreeNode invertTree(TreeNode root) {
        invertNode(root);
        return root;
    }
    
    private void invertNode(TreeNode node) {
        if (node == null) {
            return;
        }
        invertNode(node.left);
        invertNode(node.right);
        TreeNode tempLeft = node.left;
        node.left = node.right;
        node.right = tempLeft;
    }
    
}
