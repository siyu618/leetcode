package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianyuzhi on 15/11/26.
 */
public class PalindromeLinkedList {
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
    public static  boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode first = head;
        ListNode second = head;
        ListNode mid = first;
        ListNode midPre = null;
        while (second.next != null && second.next.next != null) {
            midPre = first;
            first = first.next;
            mid = first;
            second = second.next.next;
        }
        mid.next = reverse(mid.next);
        ListNode a = head;
        ListNode b = mid.next;
        boolean equal = true;
        while (a != null && b != null) {
            if (a.val != b.val) {equal = false; break;}
            a = a.next;
            b = b.next;
        }
        mid.next = reverse(mid.next);


        return equal;
    }
    public static  boolean isPalindrome2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head != null) {
            while( head != null) {
                list.add(head.val);
                head = head.next;
            }
        }
        for (int i = 0, j = list.size() -1; i <= j; i ++, j--) {
            int a = list.get(i);
            int b = list.get(j);
            if (list.get(i).intValue() != list.get(j).intValue()) {
                return false;
            }
        }
        return true;

    }

    public static ListNode genList(List<Integer> list) {
        if (list== null || list.size() == 0) return null;
        ListNode head = null;
        ListNode cur = null;
        for (Integer integer : list) {
            if (head == null) {
                head = new ListNode(integer);
                cur = head;
            }
            else {
                ListNode tmp = new ListNode(integer);
                cur.next = tmp;
                cur = tmp;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head = genList(Arrays.asList(-16557,-8725,-29125,28873,-21702,15483,-28441,-17845,-4317,-10914,-10914,-4317,-17845,-28441,15483,-21702,28873,-29125,-8725,-16557));
        head = genList(Arrays.asList(1,2,2,1));

        System.out.println(new PalindromeLinkedList().isPalindrome2(head));
        return;
    }


}
