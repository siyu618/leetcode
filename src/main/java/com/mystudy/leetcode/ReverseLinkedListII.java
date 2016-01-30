package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 15/10/2.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode middleTail = null;
        ListNode middleHead = null;
        ListNode cur = head;
        ListNode lTail = head;
        ListNode lHead = null;
        ListNode newHead = null;
        if (m > 1) {
            lHead = head;
            lTail = lHead;
            int index = 1;
            while (index < m) {
                index ++;
                lTail = cur;
                cur = cur.next;
            }
        }

        for (int i = m; i <= n; i ++) {
            ListNode tmp = cur.next;
            if (middleTail == null) {
                middleTail = cur;
                middleHead = cur;
            }
            else {
                cur.next = middleHead;
                middleHead = cur;
            }
            cur = tmp;
        }
        if (lHead == null) {
            newHead = middleHead;
            middleTail.next = cur;
        }
        else {
            newHead = lHead;
            lTail.next = middleHead;
            middleTail.next = cur;
        }

        return newHead;
    }
}
