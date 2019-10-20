package com.company;

import java.util.*;
public class MaxPathSum {


      static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

        public int maxPathSum(TreeNode root) {

            List<Integer> result = new ArrayList<>();
            result = maxPathSumHelper(root);
            return result.get(1);
        }

        public List<Integer> maxPathSumHelper(TreeNode root) {
            if(root == null) return new ArrayList<>(Arrays.asList(0,0));
            List<Integer> leftSumArray = maxPathSumHelper(root.left);
            int leftSumAsBranch = leftSumArray.get(0);
            int leftMaxSum = leftSumArray.get(1);

            List<Integer> rightSumArray = maxPathSumHelper(root.right);
            int rightSumAsBranch = rightSumArray.get(0);
            int rightMaxSum = rightSumArray.get(1);

            int maxChildSumAsBranch = Math.max(leftSumAsBranch, rightSumAsBranch);
            int maxSumAsBranch = Math.max(root.val, root.val + maxChildSumAsBranch);
            int maxSumAsTriangle = Math.max(maxSumAsBranch,leftSumAsBranch +  rightSumAsBranch + root.val);
            int maxPathSum = Math.max(maxSumAsTriangle, Math.max(leftMaxSum, rightMaxSum));

            return new ArrayList<>(Arrays.asList(maxSumAsBranch, maxPathSum));
        }
        public static void main(String[] args) {
            MaxPathSum m = new MaxPathSum();
            TreeNode root = new TreeNode(-3);
            TreeNode node = new TreeNode(-1);
            root.left = node;
            int max = m.maxPathSum(root);
            System.out.print(max);
        }
}
