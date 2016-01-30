package com.mystudy.leetcode;

import java.util.Arrays;

/**
 * Created by tianyuzhi on 15/10/2.
 */
public class DecodeWays {
    public int getAppendType(char cha, char chb) {
        int ia = cha - '0';
        int ib = chb - '0';
        if (ib == 0) {
            if (ia >= 1 && ia <= 2) {
                return 3; // must append
            }
            else {
                return 0;
            }
        }
        int tmp = ia * 10 + ib;
        if (tmp <= 0) {
            return 0; // not valid
        }
        else if ((tmp > 0 && tmp < 10) || tmp > 26) {
            return 1; // alone
        }
        else {
            return 2; // can append
        }

    }
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] res = new int[len];
        res[0] = 1;

        for (int i = 1; i <  len; i ++) {
            int appendType = getAppendType(s.charAt(i-1), s.charAt(i));
            if (appendType == 0) {
                return 0;
            }
            else if (appendType == 1) {
                res[i] = res[i-1];
            }
            else if (appendType == 2){
                res[i] = res[i-1] + ((i>1) ? res[i-2] : 1);

            }
            else {
                res[i] = ((i>1) ? res[i-2] : 1);
            }
        }
        return res[len-1];
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        for (String str : Arrays.asList("230", "0", "1", "123", "10", "1010")) {
            System.out.println(str + " : " + decodeWays.numDecodings(str));
        }
    }
}
