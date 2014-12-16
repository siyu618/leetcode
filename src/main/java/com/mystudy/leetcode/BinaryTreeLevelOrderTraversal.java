package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 14-12-14.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root  == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            queue2 = new LinkedList<TreeNode>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue2.add(node.left);
                }
                if (node.right != null) {
                    queue2.add(node.right);
                }
                level.add(node.val);
            }
            res.add(level);
            queue = queue2;

        }
        return res;
    }
}
