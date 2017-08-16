package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 17/7/26.
 */
public class ImplementTrie208 {

    static class TrieItem {
        TrieItem[] children = new TrieItem[26];
        boolean isWord = false;
        char ch;
        public TrieItem(char ch ) {
            this.ch = ch;
        }
    }
    static class Trie {
        TrieItem root = null;
        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieItem(' ');
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (null == word || word.isEmpty()) {return;}
            TrieItem cur = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (cur.children[idx] == null ) {
                    cur.children[idx] = new TrieItem(ch);
                }
                cur = cur.children[idx];
            }
            cur.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (null == word || word.isEmpty()) {return false;}
            TrieItem cur = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (cur.children[idx] == null ) {
                    return false;
                }
                else {
                    cur = cur.children[idx];
                }
            }
            return cur.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (null == prefix || prefix.isEmpty()) {return false;}
            TrieItem cur = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (cur.children[idx] == null ) {
                    return false;
                }
                else {
                    cur = cur.children[idx];
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
         //Your Trie object will be instantiated and called as such:
          Trie obj = new Trie();
          obj.insert("word");
          boolean param_2 = obj.search("wrod");
          boolean param_3 = obj.startsWith("wo");

        System.out.println(param_2);
        System.out.println(param_3);
    }
}
