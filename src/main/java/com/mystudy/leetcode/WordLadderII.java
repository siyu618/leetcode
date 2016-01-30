package com.mystudy.leetcode;

import java.util.*;

/**
 * Created by tianyuzhi on 15/11/13.
 */
public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList();
        wordList.add(endWord);
        List<List<String>> cur = new LinkedList<>();
        List<List<String>> next;
        List<String> first = new ArrayList<>();
        first.add(beginWord);
        Set<String> visited = new HashSet();
        cur.add(first);
        boolean notFound = true;
        while (cur.size() > 0) {
            next = new LinkedList<>();
            Set<String> curVisited = new HashSet();
            for (List<String> list : cur) {
                String tailStr = list.get(list.size() - 1);
                char[] chArr = tailStr.toCharArray();
                int len = tailStr.length();
                for (int i = 0; i < len; i ++) {
                    char oldCh = chArr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (chArr[i] == ch) continue;
                        chArr[i] = ch;
                        String string = String.valueOf(chArr);
                        if (string.equals(endWord)) {
                            list.add(string);
                            res.add(list);
                            notFound = false;
                        }
                        else if (wordList.contains(string) && !visited.contains(string)) {
                            List<String> newList = new ArrayList<>(list.size() + 1);
                            newList.addAll(list);
                            newList.add(string);
                            next.add(newList);
                            curVisited.add(string);
                        }

                    }
                    chArr[i] = oldCh;
                }
            }
            visited.addAll(curVisited);

            //
            cur = next;
            if (!notFound) {break;}
        }
        return res;
    }
}
