package day01.字典树的应用;

/**
 * <Description>
 * 实现字典树
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 *
 * 本质是多叉树的运用
 *
 * @author wangxi
 */
public class ImplementTrie {
    public class TrieNode {
        public boolean isWord;
        public TrieNode[] children;
        public char val;

        public TrieNode(TrieNode[] children) {
            this.children = children;
            isWord = false;
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public ImplementTrie() {
        TrieNode[] children = new TrieNode[26];
        root = new TrieNode(children);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() <= 0) {
            return;
        }
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode(new TrieNode[26]);
                p.children[index].val = c;
            }
            p = p.children[index];
        }
        p.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() <= 0) {
            return false;
        }
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() <= 0) {
            return false;
        }
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return true;
    }
}

