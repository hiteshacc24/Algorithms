package com.company;

import sun.jvm.hotspot.debugger.windbg.DLL;

import java.util.Dictionary;
import java.util.Hashtable;

public class LRUCache {
    class DLinkedNode {
        int Key;
        int Value;
        DLinkedNode next;
        DLinkedNode prev;
        DLinkedNode(int key, int value) {
            Key = key;
            Value = value;
            next = null;
            prev = null;
        }
    }
    private void addNode(DLinkedNode node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void setHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }
    private DLinkedNode popTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
    private int capacity;
    private int size;
    Hashtable<Integer, DLinkedNode> cache;
    DLinkedNode head;
    DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        cache = new Hashtable<>();
        head = new DLinkedNode(-1, -1);
        tail = new DLinkedNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) return -1;
        setHead(node);
        return node.Value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
            if(size > capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.Key);
                size--;
            }

        } else {
            node.Value = value;
            setHead(node);
        }
    }
    public static void main(String[] args) {
        LRUCache c = new LRUCache(2);
        c.put(1, 1);
        c.put(2,2);
        c.put(3,3);
        int a = c.get(1);
        System.out.print(a);
    }
}
