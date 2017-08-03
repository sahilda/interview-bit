// Valid Binary Search Tree

import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        for (int i = 0; i < queries; i++) {
            int digits = scanner.nextInt();
            ArrayList<Integer> tree = new ArrayList<Integer>();
            for (int j = 0; j < digits; j++) {
                tree.add(scanner.nextInt());
            }
            boolean response = isValidBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
            String out = response ? "YES" : "NO";
            System.out.println(out);            
        }
    }   
    
    static boolean isValidBST(ArrayList<Integer> tree, int min, int max) {
        if (tree.size() == 0) {
            return true;
        }
        ArrayList<ArrayList<Integer>> split = splitTree(tree);
        ArrayList<Integer> left = split.get(0);
        ArrayList<Integer> right = split.get(1);
        int val = tree.get(0);
        for (int i = 0; i < left.size(); i++) {
            if (left.get(i) < min || left.get(i) > val) {
                return false;
            }
        }        
        for (int i = 0; i < right.size(); i++) {
            if (right.get(i) > max || right.get(i) < val) {
                return false;
            }
        }        
        return isValidBST(left, min, val) && isValidBST(right, val, max);
    }
    
    static ArrayList<ArrayList<Integer>> splitTree(ArrayList<Integer> tree) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<ArrayList<Integer>> out = new ArrayList<>();
        int val = tree.get(0);
        boolean leftSide = true;
        for (int i = 1; i < tree.size(); i++) {
            if (tree.get(i) > val) {
                leftSide = false;
            }            
            if (leftSide) {
                left.add(tree.get(i));
            } else {
                right.add(tree.get(i));
            }
        }
        out.add(left);
        out.add(right);
        return out;
    }
}