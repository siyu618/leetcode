package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-1-3.
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String res = "";
        while (n!=0) {
            n --;
            int mod = n%26;
            char ch = (char)(mod +'A');
            res = ch + res;
            n/=26;
        }
        return res;
    }
}
