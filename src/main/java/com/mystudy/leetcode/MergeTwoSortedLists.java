package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-2-8.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode cur = null;
        ListNode tmp;
        if (l1 == null) {return l2;}
        if (l2 == null) {return l1;}
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp = l1;
                l1 = l1.next;
            } else {
                tmp = l2;
                l2 = l2.next;
            }
            if (root == null) {
                root = tmp;
                cur = tmp;
            } else {
                cur.next = tmp;
                cur = tmp;
            }
        }
        if (l1!=null) {
            cur.next = l1;
        }
        if (l2!=null) {
            cur.next = l2;
        }
        return root;

    }
}
