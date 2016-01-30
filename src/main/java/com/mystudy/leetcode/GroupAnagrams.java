package com.mystudy.leetcode;

import java.util.*;

/**
 * Created by tianyuzhi on 15/11/11.
 */
public class GroupAnagrams {
    public static class Pair {
        public String str;
        public String sorted;
        public Pair(String str, String sorted) {
            this.sorted = sorted;
            this.str = str;
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        List<Pair> list = new ArrayList<>(strs.length);
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            Pair pair = new Pair(str, new String(arr));
            list.add(pair);
        }
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.sorted.equals(o2.sorted)) {
                    return o1.str.compareTo(o2.str);
                } else {
                    return o1.sorted.compareTo(o2.sorted);
                }
            }
        });
        List<String> cur = new ArrayList<>();
        cur.add(list.get(0).str);
        String pre = list.get(0).sorted;
        for (int i = 1; i < strs.length; i ++) {
            Pair pair = list.get(i);
            if (pair.sorted.equals(pre)) {
                cur.add(pair.str);
            }
            else {
                res.add(cur);
                cur = new ArrayList<>();
                cur.add(pair.str);
            }
            pre = pair.sorted;
        }
        if (cur.size() > 0) {
            res.add(cur);
        }
        return res;


    }
}
