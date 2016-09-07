package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianyuzhi on 16/9/4.
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder_wrong(int n) {
        List<Integer> res = new ArrayList<>(5000001);
        int len = new String(n+"").length();
        for (int k = 1; k < 10; k ++) {
            for (int i = 1; i <= len; i++) {
                int startNum = k * (int)Math.pow(10, i-1);
                int endNum = Math.min((k+1) * (int)Math.pow(10, i-1)-1, n);
                for (int j = startNum; j <= endNum; j ++) {
                    res.add(j);
                }
            }
        }
        return res;
    }

    public int next(int cur, int n) {
        if (cur * 10 <= n) {
            return cur * 10;
        }
        if (cur == n) {
            cur /= 10;
        }
        cur ++;
        while (cur % 10 == 0) {
            cur /= 10;
        }
        return cur;
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        res.add(1);
        int cur = 1;
        for (int i = 1; i < n; i ++) {
            cur = next(cur, n);
            res.add(i, cur);
        }
        return res;
    }

    public static void main(String[] args) {
        LexicographicalNumbers test = new LexicographicalNumbers();
        for (int i : Arrays.asList(1,2,3,4,5,6,7,8,9,10,3,7,10,11,55,101)) {
            System.out.println(test.lexicalOrder(i));
        }
    }
}
