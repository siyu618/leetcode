package com.mystudy.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tianyuzhi on 17/7/26.
 */

public class ReplaceWords648 {

    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = build(dict);
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (String str : sentence.split(" ")) {
            if (!isFirst) {
                sb.append(' ');
            }
            isFirst = false;
            String tm = getShortest(str, root);
            sb.append(tm);

        }
        return sb.toString();

    }

    private String getShortest(String str, final TrieNode root) {
        StringBuilder sb = new StringBuilder();
        TrieNode cur = root;
        for (char ch : str.toCharArray()) {
            sb.append(ch);
            int index = ch - 'a';
            if (cur.child[index] != null) {
                cur = cur.child[index];
                if (cur.isWord) {
                    return sb.toString();
                }
            }
            else {
                break;
            }
        }
        return str;
    }




    class TrieNode {
        private static final int N = 26;
        boolean isWord = false;
        TrieNode[] child = new TrieNode[N];
        char ch;

        public TrieNode(char  ch) {
            this.ch = ch;
        }
    }

    private TrieNode build(List<String> dict) {
        TrieNode root = new TrieNode(' ');
        for (String str : dict) {
            TrieNode tmp = root;
            for (char ch : str.toCharArray()) {
                int idx = ch - 'a';
                if (tmp.child[idx] == null) {
                    tmp.child[idx] = new TrieNode(ch);
                }
                tmp = tmp.child[idx];
            }
            tmp.isWord = true;
        }
        return root;
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat", "bat", "rat");
       String sentence =  "the cattle was rattled by the battery";
        System.out.println(new ReplaceWords648().replaceWords(dict, sentence));
    }
}
