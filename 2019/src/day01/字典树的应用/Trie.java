package day01.字典树的应用;

import java.util.*;

/**
 * <Description>
 *  字典树的应用：
 *      1. 查找所有单词出现的字数
 *          1.1 也可以利用结果Map获取给单词按字典序排序的结果
 *      2. 得到以某字符串为前缀的字符串集，包括字符串本身！ 类似单词输入法的联想功能
 *      3. 先序遍历，为字符串排序
 *      4. 统计以prefix为前缀字符串的数量
 *
 *  refer link: https://blog.csdn.net/abcd_d_/article/details/40116485#commentBox
 * @author wangxi
 */
public class Trie {
    class Node {
        int wordNum;    // 单词数量
        int prefixNum;    // 前缀数
        Node[] children;
        boolean tag;       // 是否为单词节点
        public Node() {
            wordNum = 0;
            prefixNum = 0;
            children = new Node[26];
            tag = false;
        }
    }
    private Node root;
    public Trie() {
        root = new Node();
    }

    /**
     * 插入单词
     * @param word
     */
    public void insert(String word) {
        if (word == null || word.length() <= 0) {
            return;
        }
        word = word.toLowerCase();
        Node cur = root;
        char[] nums = word.toCharArray();
        for (char c : nums) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Node();
            }
            cur.children[c - 'a'].prefixNum++;
            cur = cur.children[c - 'a'];
        }
        cur.wordNum++;
        cur.tag = true;
    }

    /**
     * 统计所有单词出现次数
     */
    public void countWords() {
        Map<String, Integer> map = new LinkedHashMap<>();
        // 先序遍历
        dfs(map, root, "", new ArrayList<>());   // 后面两个为多余参数，其他方法使用
        System.out.println(map);
        System.out.println("给单词按字典序排序的结果如下：");
        System.out.println(map.keySet());
    }
    private void dfs(Map<String, Integer> map, Node root, String prefix, List<String> list) {
        if (root == null) {
            return;
        }
        if (root.tag) {
            map.put(prefix, root.wordNum);
            list.add(prefix);
            // 这里不能return。因为在树的中间和树的结尾都存在root.tag==true的情况
            //return;
        }
        // 直接遍历26个字母获取每个Node的字母值，并不需要在Node增加属性
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                // 变量s会随着栈的弹出而改变值的
                String s = prefix + (char)(i + 'a');
                dfs(map, root.children[i], s, list);
            }
        }
    }

    /**
     * 得到以某字串为前缀的字串集，包括字串本身！ 类似单词输入法的联想功能
     * @param prefix 字符串前缀
     * @return prefix存在返回true,否则false.
     */
    public boolean getWordsByPrefix(String prefix) {
        if (prefix == null || prefix.length() <= 0) {
            return false;
        }
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        // 先要找到prefix所在的节点
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        dfs(map, cur, prefix, result);
        System.out.println(map);
        System.out.println(result);
        return true;
    }

    /**
     * 判断某个单词是否存在
     * @param word
     * @return
     */
    public boolean isExist(String word) {
        return search(word);
    }

    private boolean search(String word) {
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

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("I");
        trie.insert("II");
        trie.insert("Love");
        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("xiaoliang");
        trie.insert("xiaoliang");
        trie.insert("man");
        trie.insert("handsome");
        trie.insert("love");
        trie.insert("chinaha");
        trie.insert("her");
        trie.insert("know");

        System.out.println("==========统计所有单词出现的次数开始============");
        trie.countWords();
        System.out.println("==========单词输入法的联想功能开始===========");
        trie.getWordsByPrefix("chin");
    }
}

