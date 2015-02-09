package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-1-17.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        return buildTree(num, 0, num.length-1);

    }
    public TreeNode buildTree(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = buildTree(num, start, mid-1);
        root.right = buildTree(num, mid+1, end);
        return root;
    }
}
