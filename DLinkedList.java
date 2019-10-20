package com.company;

public class DLinkedList {

    static class DLinkedNode {
        Node head;
        Node tail;
        public void setHead(Node node) {
            if(head == null) {
                head = node;
                tail = node;
                return;
            }
            insertBefore(head, node);
        }
        public void setTail(Node node) {
            if(head == null) {
                setHead(node);
                return;
            }
            insertAfter(tail, node);
        }

        public void insertBefore(Node node, Node nodeToBeInserted) {
            if(nodeToBeInserted == head && nodeToBeInserted == tail) return;
            remove(nodeToBeInserted);
            nodeToBeInserted.prev = node.prev;
            nodeToBeInserted.next = node;
            if(node.prev == null) {
                nodeToBeInserted = head;
            } else {
                node.prev.next = nodeToBeInserted;
            }
            node.prev = nodeToBeInserted;
        }
        public void insertAfter(Node node, Node nodeToBeInserted) {
            if(nodeToBeInserted == head && nodeToBeInserted == tail) return;
            remove(nodeToBeInserted);
            nodeToBeInserted.prev = node;
            nodeToBeInserted.next = node.next;
            if(node == tail) tail = nodeToBeInserted;
            else {
                node.next.prev = nodeToBeInserted;
            }
            node.next = nodeToBeInserted;
        }
        public void insertAtPosition(int pos, Node node) {
            if(pos == 1) {
                setHead(node);
                return;
            }
            int currPos = 1;
            Node temp = head;
            while(temp != null && currPos++ != pos) temp = temp.next;
            if(temp != null) insertBefore(temp, node);
            else setTail(node);

        }
        public void removeNodesWithValue(int value) {
            Node node = head;
            while(node != null) {
                Node nodeToBeDeleted = node;
                node = node.next;
                if(node.value == value) remove(nodeToBeDeleted);
            }
        }
        public void remove(Node node) {
            if(node == head) head = head.next;
            if(node == tail) tail = tail.next;
            removeBindings(node);
        }
        public boolean containsNodeWithValue(int value) {
            Node temp = head;
            while(temp != null) {
                if(temp.value == value) return true;
                temp = temp.next;
            }
            return false;
        }
        void removeBindings(Node node) {
            if(node.next != null) node.next.prev = node.prev;
            if(node.prev != null) node.prev.next = node.next;
            node.next = null;
            node.prev = null;
        }
    }
    static class Node {
        int value;
        Node prev;
        Node next;
        Node(int x) {
            value = x;
        }

    }

    public static void main(String[] args) {

    }
}
