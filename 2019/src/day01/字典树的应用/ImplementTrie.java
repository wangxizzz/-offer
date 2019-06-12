package day01.字典树的应用;

/**
 * <Description>
 * 实现字典树
 * refer website:https://leetcode.com/problems/implement-trie-prefix-tree/discuss/281717/Java74ms
 * @author wangxi
 */
public class ImplementTrie {
    class Node {
        Node[] children;
        boolean tag;
        public Node() {
            children = new Node[26];
        }
    }
    private Node root;
    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() <= 0) {
            return;
        }
        Node cur = root;
        char[] nums = word.toCharArray();
        Node[] children = cur.children;
        for (char c : nums) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new Node();
            }
            cur = children[c - 'a'];
            children = cur.children;
        }
        cur.tag = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() <= 0) {
            return false;
        }
        Node cur = root;
        Node[] children = cur.children;
        char[] nums = word.toCharArray();
        for (char c : nums) {
            if (children[c - 'a'] == null) {
                return false;
            }
            cur = children[c - 'a'];
            children = cur.children;
        }
        return cur.tag;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() <= 0) {
            return false;
        }
        Node cur = root;
        Node[] children = cur.children;
        char[] nums = prefix.toCharArray();
        for (char c : nums) {
            if (children[c - 'a'] == null) {
                return false;
            }
            cur = children[c - 'a'];
            children = cur.children;
        }
        return true;
    }
}

