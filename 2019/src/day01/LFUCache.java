package day01;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author wangxi03 created on 2021/1/6 10:50 上午
 * @version v1.0
 * https://leetcode-cn.com/problems/lfu-cache/submissions/
 */
public class LFUCache {

    public static void main(String[] args) {
        LFUCache lFUCache = new LFUCache(2);
        lFUCache.put(1, 1);
        lFUCache.put(2, 2);
        lFUCache.get(1);      // 返回 1
        lFUCache.put(3, 3);   // 去除键 2
        lFUCache.get(2);      // 返回 -1（未找到）
        lFUCache.get(3);      // 返回 3
        lFUCache.put(4, 4);   // 去除键 1
        lFUCache.get(1);      // 返回 -1（未找到）
        lFUCache.get(3);      // 返回 3
        lFUCache.get(4);      // 返回 4
    }

    private Map<Integer, Node> cache;  // 记录节点
    private Map<Integer, LinkedHashSet<Node>> freqCache; // 记录访问记录次数 -> node链表
    private int size;
    private int  capacity;
    private int min;

    public LFUCache(int capacity) {
        this.cache = new HashMap<>();
        this.freqCache = new HashMap<>();
        this.capacity = capacity;
        min = 1;
        size = 0;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        addFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.val = value;
            addFreq(node);
        } else {
            if (size == capacity) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    private void addFreq(Node node) {
        if (node == null) {
            return;
        }
        // 先从原来的链表中移除,再加入新的链表
        int count = node.freqCount;
        LinkedHashSet<Node> set1 = freqCache.get(count);
        set1.remove(node);
        if (count == min && set1.size() == 0) {
            min = count + 1;
        }
        node.freqCount++;
        LinkedHashSet<Node> newSet = freqCache.get(node.freqCount);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqCache.put(node.freqCount, newSet);
        }
        newSet.add(node);
    }

    private void addNode(Node node) {
        if (node == null) {
            return;
        }
        LinkedHashSet<Node> set = freqCache.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqCache.put(node.freqCount, set);
        }
        set.add(node);
        min = 1;
    }

    private Node removeNode() {
        LinkedHashSet<Node> set = freqCache.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }


    class Node {
        public int key;
        public int val;
        public int freqCount;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freqCount = 1;
        }
    }
}
