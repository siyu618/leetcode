package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 16/6/28.
 */
public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        long left = 1;
        long right = num;
        long lNum = num;
        while (left + 1 < right) {
            long mid = (right + left)/2;
            long tmp = mid * mid;
            if (tmp == lNum) {
                return true;
            }
            else if (tmp < lNum) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2147483647));
    }
}
