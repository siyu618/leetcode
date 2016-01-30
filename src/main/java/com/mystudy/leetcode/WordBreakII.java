package com.mystudy.leetcode;

import java.util.*;

/**
 * Created by tianyuzhi on 16/1/2.
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<List<String>> res = new ArrayList<>(s.length()+1);
        boolean[] canBreak = new boolean[s.length()+1];
        canBreak[0] = true;
        res.add(0, Arrays.asList(""));
        int len = s.length();
        for (int i = 0; i < len; i ++) {
            if (!canBreak[i]) {
                continue;
            }
            for (int j = i+1; j<=len; j ++) {
                String sub = s.substring(i, j);
                if (wordDict.contains(sub)) {
                    canBreak[j] = true;
                    List<String> list = res.get(j);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    for (String str : res.get(j)) {
                        if (str.isEmpty()) {
                            list.add(sub);
                        }
                        else {
                            list.add(str + " " + sub);
                        }
                    }
                    res.set(j, list);
                }
            }
        }
        if (!canBreak[len]) {
            return new ArrayList<>(0);
        }
        return res.get(len);
    }
    public List<String> wordBreak2(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        //List<String> curList = new ArrayList<>();
        String[] curList = new String[wordDict.size()];
        wordBreak(s, wordDict, res, curList, 0);
        return res;
    }
    public String join(List<String> list) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String str : list) {
            if (!first) {
                sb.append(' ');
            }
            first = false;
            sb.append(str);
        }
        return sb.toString();
    }
    public String join(String[] list, int start, int end) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = start; i < end; i ++) {
            if (!first) {
                sb.append(' ');
            }
            first = false;
            sb.append(list[i]);
        }
        return sb.toString();
    }
    public void wordBreak(String s, Set<String> wordDict, List<String> res, String[] curList, int index) {
        if (s.isEmpty()) {
            res.add(join(curList, 0, index));
            return;
        }
        for (int i = 1; i <= s.length(); i ++) {
            String str = s.substring(0, i);
            if (wordDict.contains(str)) {
                String sLeft = s.substring(i);
                curList[index] = str;
                wordBreak(sLeft, wordDict, res, curList, index+1);
            }
        }
    }
}
