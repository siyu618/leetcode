package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 16/5/19.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nHead = new ListNode(-1);
        nHead.next = head;
        for (ListNode cur = head; cur != null; ) {
            ListNode next = cur.next;
            for (ListNode tm = nHead.next, pre = nHead; tm != cur;) {
                if (tm.val <= cur.val) {
                    pre = tm;
                    tm = tm.next;
                }
                else {
                    cur.next = tm;
                    pre.next = cur;
                    break;
                }
            }
            cur = next;
        }
        return nHead.next;
    }
}
