package com.mystudy.leetcode;

import java.util.*;
/**
 * Created by tianyuzhi on 15/11/10.
 */
public class WordLadder {
    public  int getDistances(String x, String y) {
        int diff = 0;
        int len = x.length();
        for (int i = 0; i < len; i ++) {
            if (x.charAt(i) != y.charAt(i)) {
                diff ++;
            }
            if (diff >=2) {
                return 0;
            }
        }
        return diff < 2 ? diff : 0;
    }
    public int ladderLength2(String beginWord, String endWord, Set<String> wordList) {
            if (beginWord.equals(endWord)) {
                return 0;
        }
        Map<String, Integer> strToInt = new HashMap<>();
        int id = 0;
        wordList.add(beginWord);
        wordList.add(endWord);
        for (String word : wordList) {
            strToInt.put(word, id++);
        }
        if (strToInt.get(beginWord) == strToInt.get(endWord)) {
            return 0;
        }

        int[][] distances = new int[id][id];
        for (String word : wordList) {
            for (String word2 : wordList) {
                int x = strToInt.get(word);
                int y = strToInt.get(word2);
                if (x == y) { continue; }
                distances[x][y] = getDistances(word, word2);
            }
        }
        int start = strToInt.get(beginWord);
        int end = strToInt.get(endWord);
        boolean[] visited = new boolean[id];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int steps = 0;
        while (!queue.isEmpty()) {
            steps ++;
            int x = queue.remove();
            for (int j = 0; j < id; j++) {
                if (distances[x][j] == 1 && !visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                    if (j == end) {
                        return steps;
                    }
                }
            }
        }
        return 0;
    }

    public  boolean isOneDiff(String x, String y) {
        int diff = 0;
        int len = x.length();
        for (int i = 0; i < len; i ++) {
            if (x.charAt(i) != y.charAt(i)) {
                diff ++;
            }
            if (diff > 1) {return false;}
        }
        return diff == 1;
    }


    public int ladderLength3(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        //ordList.remove(;)
        wordList.add(endWord);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 0));
        while (!queue.isEmpty()) {
            Pair cur = queue.remove();

            for (String word : wordList) {
                if (isOneDiff(cur.str, word)) {
                    queue.add(new Pair(word, cur.steps + 1));
                    wordList.remove(word);
                    if (word.equals(cur.str)) {
                        return cur.steps + 1;
                    }
                }
            }

        }
        return 0;


    }
    public static class Pair {
        public String str;
        public int steps;
        public Pair(String str, int steps) {
            this.str = str;
            this.steps = steps;
        }
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        wordList.add(endWord);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        while (!queue.isEmpty())
        {
            Pair cur = queue.remove();
            int len = cur.str.length();
            for (int i = 0; i < len; i ++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == cur.str.charAt(i)) continue;

                    StringBuffer sb = new StringBuffer(cur.str);
                    sb.setCharAt(i, ch);
                    String str = sb.toString();

                    if (wordList.contains(str)) {
                        queue.add(new Pair(str, cur.steps + 1));
                        if (str.equals(endWord)) {
                            return cur.steps + 1;
                        }
                    }
                }
            }
        }
        return 0;

    }



}

