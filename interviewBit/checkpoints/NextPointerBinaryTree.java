/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
public class NextPointerBinaryTree {
    
    public void connect(TreeLinkNode root) {
        int level = 1;
        int nodes = 1;
        int current = 1;
        TreeLinkNode prev = null;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (queue.peek() != null) {
            TreeLinkNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
            
            if (current != 1 && current <= nodes) {
                prev.next = node;
            }
            
            if (current == nodes) {
                level++;
                nodes = nodes * 2;
                current = 1;
            } else {
                current++;
            }
            
            prev = node;
        }
    }
    
}
