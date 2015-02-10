package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-2-9.
 */
public class ValidNumber {
    public boolean isInt(String str) {
        if (str.length() == 0) {return false;}
        byte[] bytes = str.getBytes();
        int index = 0;
        if (bytes[0] == '-' || bytes[0] == '+') {
            index ++;
        }
        boolean allNum = true;
        boolean hasNum = false;
        for (int i = index; i < bytes.length; i ++) {
            if (bytes[i]>='0' && bytes[i] <='9') {
                hasNum = true;
            } else {
                allNum = false;
            }
        }
        return hasNum && allNum;
    }
    public boolean allNumber(String str) {
        boolean allNum = true;
        boolean hasNum = false;
        for (int i = 0; i < str.length(); i ++) {
            char ch = str.charAt(i);
            if (ch>='0' && ch <='9') {
                hasNum = true;
            } else {
                allNum = false;
            }
        }
        return hasNum && allNum;
    }
    public boolean isDouble(String str) {
        if (str.contains(".")) {
            String[] arr = str.split("\\.", -1);
            if (arr.length != 2) {
                return false;
            }
            if ((arr[0].isEmpty()|| arr[0].equals("-") || arr[0].equals("+")) && arr[1].isEmpty()) {
                return false;
            }
            if ((arr[0].isEmpty() || arr[0].equals("-") || arr[0].equals("+") || isInt(arr[0]))
                    && (arr[1].isEmpty() || allNumber(arr[1]))) {
                return true;

            }
            return false;
        }
        return isInt(str);
    }

    public boolean isNumber(String s) {
        if (s == null ) { return false;}
        s = s.trim();
        if (s.length() == 0) {return false;}
        if (s.contains("E")) {
            String[] arr = s.split("E", -1);
            return arr.length == 2 && isDouble(arr[0]) && isInt(arr[1]);

        }
        else if (s.contains("e")) {
            String[] arr = s.split("e", -1);
            return  arr.length == 2 && isDouble(arr[0]) && isInt(arr[1]);
        }
        return isDouble(s);

    }
    public static void main(String[] args) {
        String[] arr = {"1", " 0.1 ", "abc", "1 a", "2e10", "e", "3.", ".", "0..", ".12E3", ".12", "+.2", "+2.", ".", "-."};
        for (String str : arr) {
            System.out.println(str + " is number : " + new ValidNumber().isNumber(str));
        }
    }
}
