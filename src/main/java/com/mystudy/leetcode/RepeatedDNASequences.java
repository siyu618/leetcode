package com.mystudy.leetcode;

import java.util.*;

/**
 * Created by yidianadmin on 15-2-6.
 */
public class RepeatedDNASequences {
    public int hash(String str, int start, int end) {
        int hash = 0;
        for (int i = start; i < end;i ++) {
            char ch = str.charAt(i);
            int num = 0;
            switch (ch) {
                case 'A' : num = 0; break;
                case 'C' : num = 1; break;
                case 'T' : num = 2; break;
                case 'G' : num = 3; break;
            }
            hash = hash * 4 + num;

        }
        return hash;
    }
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<String>();
        if (s == null || s.length() < 10) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = s.length();
        int hashCode = hash(s, 0, 10);
        map.put(hashCode, 1);
        for (int i=10; i < len; i ++ ) {
            hashCode &= 0x3ffff;
            hashCode <<= 2;

            char ch = s.charAt(i);
            int num = 0;
            switch (ch) {
                case 'A' : num = 0; break;
                case 'C' : num = 1; break;
                case 'T' : num = 2; break;
                case 'G' : num = 3; break;
            }
            hashCode |= num;

            if (map.containsKey(hashCode)) {
                if (map.get(hashCode) == 1) {
                    String sub = s.substring(i-9, i+1);
                    res.add(sub);
                }
                map.put(hashCode, 2);

            }
            else {
                map.put(hashCode, 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String > list = new RepeatedDNASequences().findRepeatedDnaSequences(str);
        for (String st : list) {
            System.out.println(st);
        }
    }
}
