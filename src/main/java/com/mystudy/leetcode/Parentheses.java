package com.mystudy.leetcode;

import java.util.*;

/**
 * Created by yidianadmin on 14-11-20.
 */
public class Parentheses {
    public static  List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n==1) {res.add("()"); return res;}
        else {
            List<Set<String>> arr = new ArrayList<Set<String>>(n+1);
            Set<String> tmp = new HashSet<String>();
            tmp.add("");
            arr.add(tmp);
            for (int i = 1; i <= n; i++) {
                Set<String> tmpSet = new HashSet<String>();
                for (String str : arr.get(i - 1)) {
                    tmpSet.add("(" + str + ")");
                    tmpSet.add("()" + str);
                    tmpSet.add(str + "()");
                }
                for (int j = 2, k = i - 2; j <= k; j++, k--) {
                    Set<String> a = arr.get(j);
                    Set<String> b = arr.get(k);
                    for (String stra : a) {
                        for (String strb : b) {
                            tmpSet.add(stra + strb);
                            tmpSet.add(strb + stra);
                        }
                    }

                }
                arr.add(tmpSet);
            }
            for (Object str : arr.get(n)) {
                res.add(str.toString());
            }
            return res;
        }

    }
    public static void main(String[] args) {
        List<String> res = Parentheses.generateParenthesis(5);
        for (String str : res) {
            System.out.println(str);
        }
    }
}
