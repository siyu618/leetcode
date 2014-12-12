package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 14-12-6.
 */
public class IntersectionOfTwoLinkedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ta = headA;
        ListNode tb = headB;
        boolean taFirst = true;
        boolean tbFirst = true;
        while (ta != null && tb != null) {
            if (ta == tb) {
                break;
            }
            else {
                ta = ta.next;
                tb = tb.next;
                if (ta == null && taFirst) {ta = headB; taFirst = false;}
                if (tb == null && tbFirst) {tb = headA; tbFirst = false;}
            }
        }
        if (ta != null) {return ta;}
        else {return null;}

    }
}
