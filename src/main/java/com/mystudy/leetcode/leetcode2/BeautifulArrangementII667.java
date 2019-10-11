package com.mystudy.leetcode.leetcode2;

public class BeautifulArrangementII667 {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 1, j = n, idx = 0; i <= j; idx ++) {
            if (k > 1) {
                if (k%2 == 0) {
                    res[idx] = i;
                    i ++;
                }
                else {
                    res[idx] = j;
                    j --;
                }
                k --;
            }
            else {
                if (k % 2 == 0) {
                    res[idx] = i;
                    i ++;
                }
                else {
                    res[idx] = j;
                    j --;
                }
            }
        }
        return res;
    }
    public static void main(String... args) {
        System.out.println(new BeautifulArrangementII667().constructArray(3,2));
        System.out.println(new BeautifulArrangementII667().constructArray(3,1));
    }
}
