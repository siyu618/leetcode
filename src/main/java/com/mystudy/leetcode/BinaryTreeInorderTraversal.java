package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tianyuzhi on 15/10/2.
 */
public class BinaryTreeInorderTraversal {

    public static class NodeStatePair {
        public TreeNode treeNode;
        public int state;
        public NodeStatePair(TreeNode treeNode, int state) {
            this.treeNode = treeNode;
            this.state = state;
            /**
             * 0 : not processed
             * 1 : left processed
             * 2 : root processed
             * 3 : right processed
             */
        }

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<NodeStatePair> stack = new Stack<>();
        if (null == root) {
            return res;
        }
        stack.push(new NodeStatePair(root, 0));
        while (!stack.isEmpty()) {
            NodeStatePair top = stack.peek();
            if (top.state == 0) {
                if (top.treeNode.left != null) {
                    stack.push(new NodeStatePair(top.treeNode.left, 0));
                }
                top.state = 1;
            }
            else if (top.state == 1) {
                res.add(top.treeNode.val);
                top.state = 2;
            }
            else if (top.state == 2) {
                if (top.treeNode.right != null) {
                    stack.push(new NodeStatePair(top.treeNode.right, 0));
                }
                top.state = 3;
            }
            else if (top.state == 3) {
                stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        System.out.println(binaryTreeInorderTraversal.inorderTraversal(root));
    }
}
