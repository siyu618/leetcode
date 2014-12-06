package com.mystudy.leetcode;

import java.util.*;

/**
 * Created by yidianadmin on 14-12-5.
 */
public class MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode mergeKLists2(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node!=null) {
                queue.add(node);
            }
        }
        ListNode head = null;
        ListNode cur = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (head == null) {
                head = node;
                cur = head;
            }
            else {
                cur.next = node;
                cur = cur.next;
            }
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return head;
    }

    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        TreeMap<Integer, List<ListNode>> map = new TreeMap<Integer, List<ListNode>>();
        ListNode head = null;
        ListNode cur = head;
        for (ListNode list : lists) {
            if (null != list) {
                if (!map.containsKey(list.val)) {
                    List<ListNode> tList = new LinkedList<ListNode>();
                    tList.add(list);
                    map.put(list.val, tList);
                }
                else {
                    List<ListNode> tList = map.get(list.val);
                    tList.add(list);
                }
            }
        }
        while (!map.isEmpty()) {
            int num = map.firstKey();
            List<ListNode> list = map.firstEntry().getValue();
            List<ListNode> nextList = new LinkedList<ListNode>();
            for (ListNode node : list) {
                nextList.add(node.next);
                if (head == null) {
                    head = node;
                    cur = head;
                } else {
                    cur.next = node;
                    cur = cur.next;
                }
            }
            map.remove(num);
            for (ListNode node : nextList) {
                if (node != null) {
                    if (!map.containsKey(node.val)) {
                        List<ListNode> tList = new LinkedList<ListNode>();
                        tList.add(node);
                        map.put(node.val, tList);
                    } else {
                        List<ListNode> tList = map.get(node.val);
                        tList.add(node);
                    }
                }
            }
        }
        return head;
    }
    public static ListNode genList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length ; i ++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;

    }
    public static void main(String[] args) {
        List<ListNode> lists = new ArrayList<ListNode>();
        ListNode l1 = genList(new int[]{1, 2, 4});
        ListNode l2 = genList(new int[]{-1, 2, 3});
        ListNode l3 = null;
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        ListNode merged = mergeKLists(lists);
        ListNode tmp = merged;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();

        merged = mergeKLists2(lists);
        tmp = merged;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
