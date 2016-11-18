package com.mystudy.leetcode;
import java.util.Arrays;
import java.util.List;
/**
 * Created by tianyuzhi on 16/11/18.
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String str) {
        if (str.length() == 1) {
            return false;
        }
//        if (str.length() == 2) {
//            return true;
//        }
        boolean isAllTheSame = true;
        for (int i = 0; i < str.length(); i ++) {
            if (str.charAt(i) != str.charAt(0)) {
                isAllTheSame = false;
                break;
            }
        }
        if (isAllTheSame) return true;
        String last = str.substring(str.length()-1);
        int len = str.length();
        int prePos = 0;
        while (true) {
            int pos = str.indexOf(last, prePos);
            prePos = pos+1;
            if (len%prePos!= 0) {
                continue;
            }
            if (prePos * 2 > len) {
                break;
            }
            int curLen = pos + 1;
            String curSub = str.substring(0, curLen);
            int times = len / curLen;
            int preStart = 0;
            boolean find = true;
            for (int j = 0; j < times; j ++) {
                int tm = str.indexOf(curSub, preStart) ;
                if (tm != j * curLen) {
                    find = false;
                    break;
                }
                else {
                    preStart += curLen;
                }
            }
            if (find) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern test = new RepeatedSubstringPattern();
        List<String> list = Arrays.asList("abab","babbbbaabb", "a", "aa","abab", "aba", "abcabcabcabc");
        for (String str : list) {
            System.out.println(str + " : " + test.repeatedSubstringPattern(str));
        }
    }
}
