package com.mystudy.leetcode;

import java.util.Arrays;

/**
 * Created by tianyuzhi on 16/9/8.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static class Node {
        public int start = Integer.MAX_VALUE;
        public int end = Integer.MIN_VALUE;
        public int cnt = 0;
        public int val = -1;
        public Node(int val) {
            this.val = val;
        }
        public void update(int index) {
            start = Math.min(index, start);
            end = Math.max(index, end);
            cnt ++;
        }
    }
    public int longestSubstring(String s, int k) {
        if (null == s || s.length() == 0 || k == 0) {
            return 0;
        }
        if (k == 1) {
            return s.length();
        }
        int numNodes = 26;
        Node[] arr = new Node[numNodes];
        for (int i = 0; i < numNodes; i ++) {
            arr[i] = new Node(i);
        }
        for (int i = 0; i < s.length(); i ++) {
            int index = s.charAt(i) - 'a';
            arr[index].update(i);
        }


    }
}
