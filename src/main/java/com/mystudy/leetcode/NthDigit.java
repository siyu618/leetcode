package com.mystudy.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianyuzhi on 16/10/10.
 */
public class NthDigit {
    public int findNthDigit2(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            System.out.println(len + " has :" + (len* count));
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        System.out.println(s + " " + n);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
    public int findNthDigit(int n) {
        int N = 10;
        long[] numbers = new long[N];
        long[] total = new long[N];
        numbers[1] = 9;
        total[1] = 9;
        for (int i = 2; i < N; i++) {
            numbers[i] = numbers[i - 1] * 10 ;
            total[i] = total[i - 1] + numbers[i] * i;
        }
        return find(numbers, total, N, n);

    }

    public int find(long[] numbers, long[] total, int N, long nTh) {
//        if (nTh < 10) {
//            return nTh;
//        }
        int index = 1;
        long curTh = nTh;
        while (total[index] < nTh) {
            index++;
        }
        curTh = nTh - (int)total[index-1];
//        if (curTh == 0) return 9;
        long num = (int) Math.pow(10, index-1) + (curTh-1)/index;
        int pos = (int)(curTh - 1) % index;
        //System.out.println("==" + num + " " + curTh);
        return String.valueOf(num).charAt(pos) - '0';

    }

    public static void main(String[] args) {
        NthDigit nthDigit = new NthDigit();
        for (int i : Arrays.asList(99999,99,1, 3, 9,10,11,12,13,14,15,16,17,18, 19, 80,90,100)) {
            System.out.println(i + " : " + nthDigit.findNthDigit(i) + "===" + nthDigit.findNthDigit2(i));
        }
    }
}
