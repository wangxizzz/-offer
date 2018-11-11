package 单例模式;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/9/19 0019 20:26
 */
public class LRU<K, V> {
    private Map<K, Node<K, V>> hashMap = new HashMap<>();
    private final int MAX_SIZE = 5;
    private Node first;
    private Node last;

    public void put(K key, V value) {
        Node<K, V> node = hashMap.get(key);
        if (node == null) {
            if (hashMap.size() > MAX_SIZE) {
                //removeLat();
            }
            node = new Node<>();
            node.key = key;
        }
        node.value = value;
        hashMap.put(key, node);
        moveToFirst(node);
    }

    public V get(K key) {
        return null;
    }

    private void moveToFirst(Node<K, V> node) {
        if (node == first) {
            return;
        } else if (node == last) {
            last = last.pre;
        } else {
            node.next.pre = node.pre;
            node.pre.next = node.next;
        }
        if (first == null || last == null) {
            first = last = node;
            return;
        }
        node.next = first;
        first.pre = node;
        first = node;
        node.pre = null;
    }

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> pre;
        Node<K, V> next;
    }

}
