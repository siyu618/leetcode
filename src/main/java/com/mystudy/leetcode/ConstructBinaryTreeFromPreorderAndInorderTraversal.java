package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 15/10/4.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode build(int[] inOrder, int inStart, int inEnd, int[] preOrder, int preStart, int preEnd) {
        if (inEnd - inStart != preEnd - preStart) {
            return null;
        }
        int len = inEnd - inStart;
        if (len <= 0) {
            return null;
        }
        if (len == 1) {
            return new TreeNode(inOrder[inStart]);
        }
        int rootX = inOrder[preStart];
        int inPos = inStart;
        for (int i = inStart; i <= inEnd; i ++) {
            if (preOrder[i] == rootX) {
                inPos = i;
                break;
            }
        }
        int prePos = preStart + (inPos - inStart - 1);
        TreeNode root = new TreeNode(rootX);
        root.left = build(inOrder, inStart,inPos, preOrder, preStart, prePos+1);
        root.right = build(inOrder, inPos+1,inEnd, preOrder, prePos+1, preEnd);
        return root;
    }


    public TreeNode buildTree(int[] inOrder, int[] preOrder) {
        return build(inOrder, 0, inOrder.length, preOrder, 0, preOrder.length);
    }

}
