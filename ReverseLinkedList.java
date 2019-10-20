package com.company;

import java.util.List;

public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;

    }

    public static void removeKthNodeFromEnd(ListNode head, int k) {
        // Write your code here.
        if (head == null) return;
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        if (k == count) {
            head = head.next;
            return;
        }
        int diff = count - k;
        if (k > count) return;
        ListNode temp = head;
        for (int i = 1; i < diff; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode head = node1;
        removeKthNodeFromEnd(head, 1);
        System.out.print(head);
//        ListNode test = reverse(head);
//
//        System.out.print(test.val);


    }

}
