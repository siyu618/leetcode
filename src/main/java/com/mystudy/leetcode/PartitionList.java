package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 15/10/1.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode left = null;
        ListNode lCur = null;
        ListNode right = null;
        ListNode rCur = null;
        for (ListNode item = head.next; item != null ; item = item.next) {
            if (item.val >= x) {
                if (null != right) {
                    rCur.next = item;
                    rCur = rCur.next;
                }
                else {
                    right = item;
                    rCur = right;
                }
            }
            else {
                if (null == left) {
                    left = item;
                    lCur = left;
                }
                else {
                    lCur.next = item;
                    lCur = lCur.next;
                }
            }
        }
        if (rCur != null) {
            rCur.next = null;
        }

        ListNode newHead = null;
        if (left != null ) {
            newHead = left;
            if (right != null) {
                lCur.next = right;
            }
        }
        else {
            newHead = right;
        }

        return newHead;
    }
}
