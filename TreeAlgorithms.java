package com.company;

import java.util.ArrayList;
import java.util.Stack;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int value) {
        this.val = value;
    }
}
public class TreeAlgorithms {
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ) return null;
        if(root == p || root == q) return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
    public ArrayList<Integer> inorder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while( curr != null || !s.isEmpty()) {
            while(curr != null) {
                s.add(curr);
                curr = curr.left;
            }
            curr = s.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
    private TreeNode root;
    public static void main(String[] args) {
        TreeAlgorithms tree = new TreeAlgorithms();
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(6);
        root.left = root1;
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root3.right = root5;
        TreeNode curr = tree.lca(root, root3, root4);
        System.out.println(curr.val);
        ArrayList<Integer> output = new ArrayList<>();
        output = tree.inorder(root);
        System.out.println(output);
    }

}
