package tree.Trie;

import java.util.HashMap;

public class TrieNode {

    TrieNode[] children;
    HashMap<Character, TrieNode> map;
    boolean isWord;
    String word;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}
