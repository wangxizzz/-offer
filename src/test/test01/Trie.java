package test.test01;

/**
 * @author wangxi created on 2020/12/28 23:29
 * @version v1.0
 */
public class Trie {

    Node root = null;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() <= 0) {
            return;
        }
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Node();
                node.children[index].val = word.charAt(i);

            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() <= 0) {
            return false;
        }
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() <= 0) {
            return false;
        }
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }

    class Node {
        public Node[] children;
        public boolean isWord;
        public char val;

        public Node() {
            this.children = new Node[26];
            isWord = false;
        }
    }
}
