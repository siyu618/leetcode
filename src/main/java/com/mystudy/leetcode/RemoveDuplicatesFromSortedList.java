package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-3-6.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        int preVal = head.val;
        ListNode pre = head;
        while (cur != null) {
            if (preVal == cur.val) {
                cur = cur.next;
                pre.next = cur;
            }
            else {
                pre = cur;
                preVal = cur.val;
                cur = cur.next;
            }
        }
        return head;

    }
}
