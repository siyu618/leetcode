package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 14-12-17.
 */
/*
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}*/

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean valid = true;
        if (root.left != null) {
            if (root.left.val < root.val) {
                valid = valid && isValidBST(root.left);
            }
            else {
                return false;
            }
        }
        if (root.right != null) {
            if (root.right.val > root.val) {
                valid = valid && isValidBST(root.right);
            }
            else {
                return false;
            }
        }
        return valid;
    }
}
