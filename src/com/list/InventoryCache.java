package com.list;
import java.util.*;

public class InventoryCache<K, V> {
    private final int capacity;
    private final CustomLinkedList<K, V> list;

    public InventoryCache(int capacity) {
        this.capacity = capacity;
        this.list = new CustomLinkedList<>();
    }

    public V get(K key) {
        Node<K, V> node = list.findNodeByKey(key);
        if (node == null) return null;
        list.moveToFront(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> node = list.findNodeByKey(key);
        if (node != null) {
            node.value = value;
            list.moveToFront(node);
        } else {
            if (list.size() == capacity) {
                list.removeLast();
            }
            list.addFirst(new Node<>(key, value));
        }
    }

    private static class CustomLinkedList<K, V> {
        private Node<K, V> head, tail;
        private int size = 0;

        public CustomLinkedList() {
            head = new Node<>(null, null);
            tail = new Node<>(null, null);
            head.next = tail;
            tail.prev = head;
        }

        public void addFirst(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        public void moveToFront(Node<K, V> node) {
            remove(node);
            addFirst(node);
        }

        public Node<K, V> removeLast() {
            if (tail.prev == head) return null;
            Node<K, V> last = tail.prev;
            remove(last);
            return last;
        }

        public void remove(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node<K, V> findNodeByKey(K key) {
            Node<K, V> current = head.next;
            while (current != tail) {
                if (current.key.equals(key)) {
                    return current;
                }
                current = current.next;
            }
            return null;
        }

        public int size() {
            return size;
        }
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev, next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}



