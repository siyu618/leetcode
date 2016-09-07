package com.mystudy.leetcode;

import java.util.Random;

/**
 * Created by tianyuzhi on 16/8/24.
 */
public class LinkedListRandomNode {
    private ListNode head;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = head;
        ListNode res = cur;
        int index = 1;
        Random random = new Random();
        while (cur.next != null) {
            index ++;
            if (random.nextInt(index) == 0) {
                res = cur.next;
            }
            cur = cur.next;
        }
        return res.val;
    }
}
