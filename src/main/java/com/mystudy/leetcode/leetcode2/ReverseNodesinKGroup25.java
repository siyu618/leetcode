package com.mystudy.leetcode.leetcode2;

public class ReverseNodesinKGroup25 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }


        ListNode tail = head;
        int kk = k;
        while (kk > 1 && tail != null) {
            tail = tail.next;
            kk--;
        }
        if (kk > 1 || tail == null) {
            return head;
        }

        ListNode nHead = head;
        ListNode nTail = head;
        head = head.next;
        ListNode nextHead = tail.next;
        for (int i = 1; i < k; i++) {
            ListNode next = head.next;
            head.next = nHead;
            nHead = head;
            head = next;
        }
        nTail.next = reverseKGroup(nextHead, k);
        return nHead;
    }

    public  ListNode createList(int[] list) {
        if (null == list || 0 == list.length) {
            return null;
        }
        ListNode head = new ListNode(list[0]);
        ListNode cur = head;
        for (int i = 1; i < list.length; i ++) {
            ListNode node  = new ListNode(list[i]);
            cur.next = node;
            cur = node;
        }
        return head;
    }

    public void print(ListNode head)
    {
        while (head != null ) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String... args) {
        ReverseNodesinKGroup25 test =  new ReverseNodesinKGroup25();
        ListNode head = test.createList(new int[]{1,2,3,4,5});
        int k = 2;
       test.print(test.reverseKGroup(head, 3));
    }
}
