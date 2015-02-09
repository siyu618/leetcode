package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-2-8.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int[] res = new int[Math.max(a.length(), b.length())+1];
        for (int i = 0; i < res.length; i ++) {
            res[i] = 0;
        }
        int index = 0;
        int lenB = b.length();
        int lenA = a.length();
        for (int i = lenA - 1; i >=0; i --) {
            res[lenA-i-1] = a.charAt(i) - '0';
        }
        for (int i = lenB - 1; i >=0; i --) {
            res[lenB-i-1] += b.charAt(i) - '0';
        }
        int add = 0;
        int maxIndex = 0;
        for (int i = 0; i < res.length; i ++) {
            res[i] += add;
            add = res[i]/2;
            res[i] = res[i]%2;
            if (res[i]>0) {
                maxIndex = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = maxIndex; i >= 0; i --) {
            sb.append(res[i]);
        }
        return sb.toString();


    }
}
