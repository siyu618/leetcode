//package com.mystudy.leetcode;
//
///**
// * Created by tianyuzhi on 15/10/4.
// */
//public class ConstructBinaryTreeFromInorderAndPostOrderTraversalTo {
//
//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }
//   public TreeNode build(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
//        int len = inEnd - inStart;
//        if (len <= 0) {
//            return null;
//        }
//        if (len == 1) {
//            return new TreeNode(inOrder[inStart]);
//        }
//        int rootX = postOrder[postEnd-1];
//        int inPos = -1;
//        int leftLen = 0;
//        for (int i = inStart; i < inEnd; i ++) {
//            if (inOrder[i] == rootX) {
//                inPos = i;
//                break;
//            }
//            leftLen ++;
//        }
//        TreeNode root = new TreeNode(rootX);
//        int postPos = postStart + leftLen - 1;
//        root.left = build(inOrder, inStart,inPos, postOrder, postStart, postPos+1);
//        root.right = build(inOrder, inPos+1,inEnd, postOrder, postPos+1, postEnd-1);
//        return root;
//    }
//    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
//        return build(inOrder, 0, inOrder.length, postOrder, 0, postOrder.length);
//    }
//
//    public static void print(TreeNode root) {
//        if (root == null) {System.out.println("#");}
//        else {
//            System.out.println(root.val + "\t");
//            print(root.left);
//            print(root.right);
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] in = {1,2,3,4,5};
//        int[] post = {4,3,5,2,1};
//        print(new ConstructBinaryTreeFromInorderAndPostOrderTraversalTo().buildTree(in, post));
//    }
//}
