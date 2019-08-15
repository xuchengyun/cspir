package tree.Trie.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _212_WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> res) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        char cur = board[i][j];
        if (cur == '#' || root.children[cur - 'a'] == null) return;
        root = root.children[cur - 'a'];
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j, root, res);
        dfs(board, i + 1, j, root, res);
        dfs(board, i, j - 1, root, res);
        dfs(board, i, j + 1, root, res);
        board[i][j] = cur;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
