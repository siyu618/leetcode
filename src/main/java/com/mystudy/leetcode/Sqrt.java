package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-2-9.
 */
public class Sqrt {

    public int sqrt(int x) {
        if (x < 0) {return -1;}
        if (x <= 1) {return x;}
        long left = 0;
        long right = x;
        long pre = -1;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long tmp = mid * mid;
            if (pre == tmp) {
                break;
            }
            if (tmp < x) {
                left = mid;
            } else if (tmp == x) {
                return (int)mid;
            } else {
                right = mid;
            }
            pre = tmp;
        }
        return (int)left;
    }
    public static void main(String[] args) {
        int [] arr = {/*0, 1,3,4, 5,6,7,8,9, 10, 11,*/ 2147395599};
        for (int i : arr) {
            System.out.println(i + " " + new Sqrt().sqrt(i));
        }
    }
}
