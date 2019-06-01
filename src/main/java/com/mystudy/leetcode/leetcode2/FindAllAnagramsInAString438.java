package com.mystudy.leetcode.leetcode2;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString438 {
    private boolean isSame(int[] org, int[] cur) {
        for (int i = 0; i < org.length; i ++) {
            if (org[i] != cur[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int M = 26;

        if (s.length() < p.length()) {
            return new ArrayList();
        }
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int[] org = new int[M];
        int[] cur = new int[M];
        List<Integer> res = new ArrayList(ss.length);
        for (int i = 0; i < pp.length; i ++) {
            org[pp[i] - 'a'] ++;
            cur[ss[i] - 'a'] ++;
        }
        if (isSame(org, cur)) {
            res.add(0);
        }
        for (int i = pp.length; i < ss.length; i ++) {
            cur[ss[i] - 'a'] ++;
            cur[ss[i - pp.length] - 'a'] --;
            if (isSame(cur, org)) {
                res.add(i - pp.length+1);
            }
        }
        return res;

    }

    public static void main(String... args) {
        String s = "baa";
        String p = "aa";
        System.out.println(new FindAllAnagramsInAString438().findAnagrams(s, p));
    }
}
