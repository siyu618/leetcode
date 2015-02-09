package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-2-7.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null) {return 0;}
        int len = 0;
        int last = s.length()-1;
        while (last >= 0 && s.charAt(last) == ' ') {
            last --;
        }
        for (int i = last; i >=0 && s.charAt(i) != ' '; i --) {
            len ++;
        }
        return len;

    }
}
