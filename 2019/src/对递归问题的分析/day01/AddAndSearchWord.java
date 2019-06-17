package 对递归问题的分析.day01;

/**
 * <Description>
 *
 * @author wangxi
 */
public class AddAndSearchWord {

    public static void main(String[] args) {
        AddAndSearchWord addAndSearchWord = new AddAndSearchWord();
        addAndSearchWord.addWord("at");
        addAndSearchWord.addWord("and");
        addAndSearchWord.addWord("an");
        addAndSearchWord.addWord("add");
        addAndSearchWord.addWord("bat");
        //System.out.println(addAndSearchWord.search("an."));
        System.out.println(addAndSearchWord.search(".at"));
    }

    class Node {
        Node[] children;
        boolean tag;
        public Node() {
            children = new Node[256];
        }
    }
    private Node root;
    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() <= 0) {
            return;
        }
        Node cur = root;
        char[] nums = word.toCharArray();
        for (char c : nums) {
            if (cur.children[c] == null) {
                cur.children[c] = new Node();
            }
            cur = cur.children[c];
        }
        cur.tag = true;
    }
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.length() <= 0) {
            return false;
        }
        Node cur = root;
        return dfs(cur, word, 0);
    }

    // 这种对树的全部搜索一遍，最终的返回的结果是最后一次搜索路径所得到的结果。
    // 因为在前面搜索所压入的栈，全部都return了，
    // 因此是取最后一条路径的结果作为最终返回的结果

    //所以，得到结论：
    // 如果想要在某条路径得到true后，就直接返回最终结果，那么就必须利用方法的返回值进行return.
    // 可以参照下面的反例。

    private boolean dfs(Node root, String word, int index) {   // 正确解法
        if (index == word.length()) {
            return root.tag;
        }
        char c = word.charAt(index);
        index++;
        if (c == '.') {
            for (char i = 'A'; i <= 'z'; i++) {
                if (root.children[i] == null) {
                    continue;
                }
                boolean flag = dfs(root.children[i], word, index);
                // 只要有一条路径返回true，就返回最终结果
                if (flag) {
                    return true;
                }
            }
            return false;
        } else {
            if (root.children[c] == null) {
                return false;
            }
            boolean flag = dfs(root.children[c], word, index);
            // 利用方法的返回值，返回给回退后的方法，然后继续回退
            return flag;
        }
    }


    // TODO 反例演示，没有利用dfs的返回值，就会导致扫描整棵树
    private boolean dfs2(Node root, String word, int index, char c) {
        if (index != -1) {
            if (word.charAt(index) != c && c != '.') {
                return false;
            }
        }
        if (index == word.length() - 1) {
            return true;
        }
        char i = 'A';
        for ( ;i <= 'z'; i = (char)(i + 1)) {
            if (root.children[i] == null) {
                continue;
            }
            dfs2(root.children[i], word, index++, i);
        }
        return true;
    }
}

