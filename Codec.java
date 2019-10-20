package com.company;

import java.util.*;

public class Codec {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public String Serialize(TreeNode root) {
        if(root == null) {
            return("null" + ",");
        }
        String leftSerialized = Serialize(root.left);
        String rightSerialized = Serialize(root.right);
        return root.val + "," + leftSerialized + rightSerialized;
    }
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return helper(q);

    }
    public TreeNode helper(Queue<String> q) {
        String s = q.poll();
        if(s.equals("null")) return null;
        int x = Integer.parseInt(s);
        TreeNode node = new TreeNode(x);
        node.left = helper(q);
        node.right = helper(q);
        return node;
    }
    public static void main(String[] args) {
        Codec c = new Codec();
        TreeNode tree = new TreeNode(0);
        TreeNode tree1 = new TreeNode(1);
        TreeNode tree2 = new TreeNode(2);
        TreeNode tree3 = new TreeNode(3);
        TreeNode tree4 = new TreeNode(4);
        tree.left = tree1;
        tree.right = tree2;
        tree.left.left = tree3;
        tree.left.right = tree4;
        String data = c.Serialize(tree);
        TreeNode node = c.deserialize(data);
        System.out.print(data);
    }
}