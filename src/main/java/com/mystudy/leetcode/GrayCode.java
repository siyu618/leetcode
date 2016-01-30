package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianyuzhi on 15/10/1.
 */
public class GrayCode {

    public int getInt(int[] binary, int n) {
        int res = binary[0];
        for (int i = 1; i < n; i ++) {
            res = res * 2 + (binary[i] ^ binary[i-1]);
        }
        return res;
    }

    public void grayCode(List<Integer> res, int[] binary, int n, int index) {
        if (index == n) {
            res.add(getInt(binary, n));
            return;
        }

        binary[index] = 0;
        grayCode(res, binary, n, index + 1);
        binary[index] = 1;
        grayCode(res, binary, n, index + 1);
    }

    public List<Integer> grayCode(int n) {

        int [] binary = new int[n];
        List<Integer> res = new ArrayList<>((int)Math.pow(2.0, n));
        grayCode(res, binary, n, 0);
        return res;
    }

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        System.out.println(grayCode.grayCode(2));
        System.out.println(grayCode.grayCode(3));
    }
}
