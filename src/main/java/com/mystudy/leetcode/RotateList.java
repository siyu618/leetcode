package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-2-8.
 */
public class RotateList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode step(ListNode cur, int n) {
        while (n > 0 && cur!= null) {
            cur = cur.next;
            n--;
        }
        return cur;
    }

    public int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len ++;
            head = head.next;
        }
        return len;
    }

    public ListNode rotateRight(ListNode head, int n) {
        int len = getLength(head);
        if (len < 2) {
            return head;
        }

        n = n % len;
        if (n == 0) {return head;}
        ListNode newTail = step(head, len-n-1);
        ListNode newHead = newTail.next;
        ListNode tail = step(newHead, n-1);
        tail.next = head;
        newTail.next = null;
        return newHead;
    }
}
