package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yidianadmin on 14-12-13.
 */
public class SubstringWithConcatenationOfAllWords {
    public boolean isSame(Map<String, Integer> a, Map<String, Integer> b) {
        if (a == b) {
            return true;
        }
        if (a==null||b==null) {return false;}
        for (String str : a.keySet()) {
            if (b.containsKey(str) && (Integer)a.get(str) == (Integer)b.get(str)) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
    public List<Integer> findSubstring(String Str, String[] L) {
        if (Str == null || Str.isEmpty() || L == null || L.length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();
        Map<String, Integer> hasMap = new HashMap<String, Integer>();
        for (String str : L) {
            int c = 0;
            if (hasMap.containsKey(str)) {
                c = hasMap.get(str);
            }
            hasMap.put(str, c+1);
        }
        int minLen = L.length * L[0].length();
        int strLen = L[0].length();
        for (int i = 0; i + minLen-1 < Str.length(); i ++ ) {
            Map<String, Integer> workingMap = new HashMap<String, Integer>();
            for (int j = 0; j < L.length; j ++) {
                String sub = Str.substring(i+j*strLen, i+(j+1)*strLen);
                if (!hasMap.containsKey(sub)) {
                    break;
                }
                int c = 0;
                if (workingMap.containsKey(sub)) {
                    c = workingMap.get(sub);
                }
                workingMap.put(sub, c+1);
                if (c+1>hasMap.get(sub)) {
                    break;
                }
            }
            if (isSame(hasMap, workingMap)) {
                list.add(i);
            }

        }
        return list;
    }

    public static void main(String[] args) {
        String S = "abababab";
        String[] L = {"ab", "ab"};
        List<Integer> res = new SubstringWithConcatenationOfAllWords().findSubstring(S, L);
        for (Integer i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
