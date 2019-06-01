package com.mystudy.leetcode.leetcode2;

public class ValidNumber65 {
    public boolean isNumber(String s) {
        if (null == s || s.isEmpty()) {
            return true;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return false;
        }
        if (s.indexOf('e') != -1) {
            String[] arr = s.split("e", -1);
            if (arr.length != 2) {
                return false;
            }
            return isDouble(arr[0]) && notZero(arr[0]) && isInteger(arr[1]) && notZero(arr[1]);
        }
        else {
            return isDouble(s);
        }
    }
    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
    private boolean isSign(char ch) {
        return ch == '+' || ch == '-';
    }
    private boolean isPositiveInteger(String str) {
        int idx = 0;
        while (idx < str.length()) {
            if (!isDigit(str.charAt(idx))) {
                return false;
            }
            idx ++;
        }
        return true;
    }
    private boolean isInteger(String str) {
        if (str.isEmpty()) {
            return true;
        }
        if (isSign(str.charAt(0))) {
            return isPositiveInteger(str.substring(1));
        }
        else {
            return isPositiveInteger(str);
        }
    }

    private boolean notZero(String str) {
        int idx = 0;
        while (idx < str.length()) {
            if (str.charAt(idx) != 0 && isDigit(str.charAt(idx))) {
                return true;
            }
            idx ++;
        }
        return false;
    }

    private boolean isDouble(String str) {
        if (str.indexOf('.') != -1) {
            String[] arr = str.split("\\.", -1);
            if (arr.length != 2) {
                return false;
            }
            return isInteger(arr[0]) && isPositiveInteger(arr[1]) && (notZero(arr[0]) || notZero(arr[1]));
        }
        else {
            return isInteger(str);
        }
    }

    public static void main(String... args) {
        ValidNumber65 test = new ValidNumber65();
        System.out.println(test.isNumber(" e3 "));
        return ;
    }
}
