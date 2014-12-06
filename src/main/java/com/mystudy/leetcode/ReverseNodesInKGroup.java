package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 14-11-20.
 */
public class ReverseNodesInKGroup {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        ListNode cur = head;
        int count = 1;
        while (count < k && cur != null) {
            cur = cur.next;
            count++;
        }
        if (count < k || cur == null) {
            return head;
        }
        ListNode pre = head;
        ListNode next = head.next;
        ListNode tail = reverseKGroup(cur.next, k);
        ListNode tmp;
        while (next != cur) {
            tmp = next.next;
            next.next = pre;
            next = tmp;
        }
        cur.next = pre;
        head.next = tail;
        return cur;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        ListNode newead = ReverseNodesInKGroup.reverseKGroup(head, 2);

    }
}
