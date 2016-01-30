package com.mystudy.leetcode;

import java.util.*;

/**
 * Created by tianyuzhi on 16/1/29.
 */

class Node {
    private int key;
    private int val;
    Node prev, next;
    public int getKey() {
        return key;
    }
    public int getVal() {
        return val;
    }
    public void setVal(int val) {
        this.val = val;
    }
    public Node() {
        this.prev = this.next = null;
    }

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = this.next = null;
    }
}

class DoubleLinkedList {
    private Node head = new Node();
    private Node tail = new Node();

    public DoubleLinkedList() {
        this.head.next = tail;
        this.tail.prev = head;
    }

    public void addFirst(Node node) {
        if (node == null) return;
        Node tm = head.next;
        node.next = tm;
        node.prev = head;
        head.next = node;
        tm.prev = node;

    }

    public Node removeLast() {
        if (tail.prev == head) return null;
        Node tm = tail.prev.prev;
        Node deletedNode = tail.prev;
        tm.next = tail;
        tail.prev = tm;
        deletedNode.next = null;
        deletedNode.prev = null;
        return deletedNode;
    }

    public void moveToFirst(Node node) {
        if (node == null ) return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addFirst(node);
    }
}

public class LRUCache {
    private int capacity;
    private DoubleLinkedList linkedList = new DoubleLinkedList();
    private Map<Integer, Node> store = new HashMap<>();


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (store.containsKey(key)) {
            Node node = store.get(key);
            linkedList.moveToFirst(node);
            return node.getVal();
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (store.containsKey(key)) {
            Node node = store.get(key);
            node.setVal(value);
            linkedList.moveToFirst(node);
        } else {
            Node node = new Node(key, value);
            store.put(key, node);
            linkedList.addFirst(node);
        }
        if (store.size() > capacity) {
            Node tm = linkedList.removeLast();
            store.remove(tm.getKey());
        }
    }
}