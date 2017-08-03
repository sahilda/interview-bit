// Creating a Binary Search Tree

/*
 * Complete the function below.
 */

    static int counter;

    static void createBST(int[] keys) {
        counter = 0;
        Node head = null;
        for (int k : keys) {
            if (head == null) {
                Node node = new Node(k);
                head = node;
            } else {
                insert(head, k);
            }
            System.out.println(counter);
        }

    }

    static void insert(Node root, int val) {
        counter++;
        if (val < root.value) {
            if (root.left == null) {
                Node node = new Node(val);
                root.left = node;
            } else {
                insert(root.left, val);
            }
        } else {
            if (root.right == null) {
                Node node = new Node(val);
                root.right = node;
            } else {
                insert(root.right, val);
            }
        }
    }

    static class Node {        
        Node left;
        Node right;
        int value;
        
        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }