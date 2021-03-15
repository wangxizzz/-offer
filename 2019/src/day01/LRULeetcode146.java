package day01;

import java.util.HashMap;
import java.util.Map;

/**
 * <Description>
 *
 * @author wangxi
 */
public class LRULeetcode146 {
    private Node head;
    private Node end;
    private Map<Integer, Node> map;
    private int cap;
    public LRULeetcode146(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToFirst(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            if (map.size() == cap) {
                // 删掉过期节点
                removeExpireNode();
            }
            node = new Node(key, value);
        }
        node.value = value;
        map.put(key, node);
        moveToFirst(node);
    }
    private void removeExpireNode() {
        int key = end.key;
        end = end.pre;
        if (end != null) {
            end.next = null;
        }
        map.remove(key);
    }
    private void moveToFirst(Node node) {
        if (head == null || end == null) {
            head = end = node;
            return;
        }
        if (node == head) {
            return;
        }
        if (node == end) {
            end = end.pre;
            if (end != null) {
                end.next = null;
            }
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        node.pre = null;
        node.next = head;
        head.pre = node;
        head = node;
    }
    private class Node {
        int key;
        int value;
        Node pre;
        Node next;
        // 注意：node 的构建函数是 key-value结果，LFU也是如此
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

