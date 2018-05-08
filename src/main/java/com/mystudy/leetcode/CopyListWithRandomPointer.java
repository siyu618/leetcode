package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 18/5/8.
 */

/**
 * Definition for singly-linked list with a random pointer.
 */
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};


public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (null == head) {
            return head;
        }
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode next = cur.next;
            RandomListNode tm = new RandomListNode(cur.label);
            tm.next = next;
            cur.next = tm;
            cur = next;
        }

        cur = head;
        while (cur != null) {
            RandomListNode newListNode = cur.next;
            newListNode.random = ((cur.random == null) ? null :  cur.random.next);
            cur = cur.next.next;
        }

        RandomListNode newListHead = head.next;
        RandomListNode newListCur = null;
        cur = head;
        while (cur != null) {
            RandomListNode newListNode = cur.next;
            RandomListNode curNext = cur.next.next;

            newListNode.next = null;
            if (newListCur == null) {
               newListCur = newListNode;
            }
            else {
                newListCur.next = newListNode;
                newListCur = newListCur.next;
            }
            cur.next = curNext;
            cur = curNext;
        }
        return newListHead;
    }

    public void test1(){
        RandomListNode head = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);


        //
        head.next = n2;
        head.random = n3;
        n2.next = n3;
        n2.random = head;
        n3.random = n2;

        RandomListNode newHead = new CopyListWithRandomPointer().copyRandomList(head);
        System.out.println(newHead);

    }

    public void test2() {
        RandomListNode head = new RandomListNode(1);


        //
        head.random = head;
        RandomListNode newHead = new CopyListWithRandomPointer().copyRandomList(head);
        System.out.println(newHead);

    }

    public static void main(String[] args) {
        new CopyListWithRandomPointer().test1();

        new CopyListWithRandomPointer().test2();


    }
}
