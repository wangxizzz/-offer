package day01.字典树的应用;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <Description>
 *
 * @author wangxi
 */
public class WordSearchII {
    class Node {
        String word;
        Node[] children;
        boolean tag;
        public Node() {
            children = new Node[26];
        }
    }
    private Node root;
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length <= 0 || words == null || words.length <= 0) {
            return null;
        }
        root = new Node();
        for (String s : words) {
            insert(s, root);
        }
        Set<String> set = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0 ; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Node cur = root;
                dfs(set, board, cur, i, j);
            }
        }
        return new ArrayList<>(set);
    }

    private void dfs(Set<String> result, char[][] board, Node root, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {
            return;
        }
        char temp = board[i][j];
        Node child = root.children[temp - 'a'];
        if (child == null) {
            return;
        } else {
            if (child.tag) {
                result.add(child.word);
            }
        }
        board[i][j] = '#';
        dfs(result, board, child, i + 1, j);
        dfs(result, board, child, i - 1, j);
        dfs(result, board, child, i, j - 1);
        dfs(result, board, child, i, j + 1);
        board[i][j] = temp;

    }

    private void insert(String word, Node root) {
        Node cur = root;
        char[] nums = word.toCharArray();
        for (char c : nums) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Node();
            }
            cur = cur.children[c - 'a'];
        }
        cur.tag = true;
        cur.word = word;
    }
}

