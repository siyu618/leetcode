package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 15/10/23.
 */
public class PopulatingNextRightPointersInEachNodeII {

    //  Definition for binary tree with next pointer.
      public static class TreeLinkNode {
          int val;
          TreeLinkNode left, right, next;
          TreeLinkNode(int x) { val = x; }
     }

    public void connect(TreeLinkNode root) {
        if (root == null) {return;}
        root.next = null;

        TreeLinkNode pre = root;
        TreeLinkNode cur = (root.left != null) ? root.left : root.right;

        while (cur != null) {
            TreeLinkNode lastFloor = pre;
            pre = cur;
            TreeLinkNode firstNonNull = null;

            while (lastFloor != null) {
                if (lastFloor.left != null && lastFloor.left != cur) {
                    cur.next = lastFloor.left;
                    cur = cur.next;
                }
                if (lastFloor.right != null && lastFloor.right != cur) {
                    cur.next = lastFloor.right;
                    cur = cur.next;
                }
                lastFloor = lastFloor.next;
            }
            for (TreeLinkNode tmp = pre; tmp != null; tmp = tmp.next) {
                if (tmp.left != null) {
                    firstNonNull = tmp.left;
                    break;
                }
                if (tmp.right != null) {
                    firstNonNull = tmp.right;
                    break;
                }
            }
            cur = firstNonNull;
        }
    }

    //{3,9,20,#,#,15,7}
    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(3);
        root.left = new TreeLinkNode(9);
        TreeLinkNode right = new TreeLinkNode(20);
        root.right = right;
        right.left = new TreeLinkNode(15);
        right.right = new TreeLinkNode(7);
        new PopulatingNextRightPointersInEachNodeII().connect(root);
    }
}
