package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-1-3.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s== null || s.isEmpty()) {
            return 0;
        }
        int res = 0;
        for (int i =0; i<s.length(); i ++) {
            int cur = s.charAt(i) - 'A' + 1;
            res = res * 26 + cur;
        }
        return res;
    }
}
