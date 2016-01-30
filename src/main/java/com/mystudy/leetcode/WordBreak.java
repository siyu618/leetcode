package com.mystudy.leetcode;


import  java.util.*;
/**
 * Created by tianyuzhi on 15/12/31.
 */
public class WordBreak {
    public boolean wordBreak3(String s, Set<String> wordDict) {
        boolean[] matched = new boolean[s.length() + 1];
        matched[0] = true;
        for (int i = 0; i < s.length(); i ++) {
            if (!matched[i]) continue;
            for (int j = 1; i+j<=s.length();j ++) {
                String sub = s.substring(i, i+j);
                if (wordDict.contains(sub)) {
                    matched[i + j] = true;
                }
            }
        }
        return matched[s.length()];
    }
    public boolean wordBreak2(String s, Set<String> wordDict) {
        boolean[] matched = new boolean[s.length() + 1];
        matched[0] = true;
        for (int i = 0; i < s.length(); i ++) {
            if (!matched[i]) continue;
            String sub = s.substring(i);
            for (String word : wordDict) {
                if (matched[i] && sub.startsWith(word)) {
                    matched[i+word.length()] = true;
                }
            }
        }
        return matched[s.length()];
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        Set<String> used = new HashSet<>();
        return wordBreak(s, wordDict, used);
       // return false;
    }

    public boolean wordBreak(String s, Set<String> wordDict, Set<String> usedDict) {
        if (s.isEmpty()) {
            return true;
        }
        boolean canBread = false;
        for (int i = 1; i <= s.length(); i ++) {
            String tm = s.substring(0, i);
            if (usedDict.contains(tm) || !wordDict.contains(tm)) {
                continue;
            }
            usedDict.add(tm);
            wordDict.remove(tm);
            canBread = wordBreak(s.substring(i, s.length()), wordDict, usedDict);
            if (canBread) return true;
            usedDict.remove(tm);
            wordDict.add(tm);
        }
        return canBread;
    }

    public static void main(String[] args)
    {
        WordBreak wordBreak  = new WordBreak();
        String str = "leetcode";
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak.wordBreak3(str, dict));
    }
}
