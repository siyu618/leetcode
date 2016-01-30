package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 15/12/8.
 */
public class ReorderList {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = cur;
            cur = head;
            head = next;
        }
        return cur;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode l1 = head;
        ListNode l1Pre = null;
        ListNode l2 = head;
        while (l2 != null && l2.next != null) {
            l1Pre = l1;
            l1 = l1.next;
            l2 = l2.next.next;
        }
        l1Pre.next = null;
        l1 = reverse(l1);
        ListNode nHead = null;
        ListNode cur = null;
        while (head != null && l1 != null) {
            ListNode hNext = head.next;
            ListNode l1Next = l1.next;
            if (nHead == null) {
                nHead = head;
                cur = nHead;
                cur.next = null;
            }
            else {
                cur.next = head;
                cur = cur.next;
                cur.next = null;
            }
            cur.next = l1;
            cur = cur.next;
            cur.next = null;
            head = hNext;
            l1 = l1Next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        head = nHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        new ReorderList().reorderList(head);
    }
}
