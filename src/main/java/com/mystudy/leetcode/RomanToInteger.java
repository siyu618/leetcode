package com.mystudy.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tianyuzhi on 15/10/8.
 */
public class RomanToInteger {
    public String intToRoman(int num) {
        String res = "";
        while (num != 0) {
            if (num >= 1000) {
                int tmp = num / 1000;
                for (int i = 0; i < tmp; i++) {
                    res += "M";
                }
                num %= 1000;
            } else if (num >= 100 && num < 1000) {
                int tmp = num / 100;
                if (tmp == 9) {
                    res += "CM";
                } else if (tmp >= 5 && tmp < 9) {
                    res += "D";
                    for (int i = 5; i < tmp; i++) {
                        res += "C";
                    }
                } else if (tmp == 4) {
                    res += "CD";
                } else {
                    for (int i = 0; i < tmp; i++) {
                        res += "C";
                    }
                }
                num %= 100;

            } else if (num >= 10 && num < 100) {
                int tmp = num / 10;
                if (tmp == 9) {
                    res += "XC";
                } else if (tmp >= 5 && tmp < 9) {
                    res += "L";
                    for (int i = 5; i < tmp; i++) {
                        res += "X";
                    }
                } else if (tmp == 4) {
                    res += "XL";
                } else {
                    for (int i = 0; i < tmp; i++) {
                        res += "X";
                    }
                }
                num %= 10;

            } else if (num >= 1 && num < 10) {
                int tmp = num / 1;
                if (tmp == 9) {
                    res += "IX";
                } else if (tmp >= 5 && tmp < 9) {
                    res += "V";
                    for (int i = 5; i < tmp; i++) {
                        res += "I";
                    }
                } else if (tmp == 4) {
                    res += "IV";
                } else {
                    for (int i = 0; i < tmp; i++) {
                        res += "I";
                    }
                }
                num %= 1;
            }
        }
        return res;
    }
    public int romanToInt(String s) {
        // refer to : http://blog.163.com/zili_qu/blog/static/264743362007715115523867/
        // I（代表1）、V（代表5）、X（代表10）、L（代表50）、C代表100）、D（代表500）、M（代表1,000）
        // 1．重复次数：一个罗马数字符号重复几次，就表示这个数的几倍。如：“III”表示“3”；“XXX”表示“30”。

        //2．右加左减：一个代表大数字的符号右边附一个代表小数字的符号，就表示大数字加小数字，如“VI”表示“6”，“DC”表示“600”。一个代表大数字的符号左边附一个代表小数字的符号，就表示大数字减去小数字的数目，如“IV”表示“4”，“XL”表示“40”，“VD”表示“495”。
        if (null == s || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map;
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        map.put('Z', 10000000);
        int num = 0;
        for (int i = s.length() - 1; i >=0 ; ) {
            if (i == 0) {
                num += map.get(s.charAt(0));
                break;
            }
            char preCh = s.charAt(i-1);
            int pre = map.get(preCh);
            char ch = s.charAt(i);
            int cur = map.get(ch);
            if (cur <= pre) {
                i --;
                num += cur;
            }
            else {
                num  += cur - pre;
                i -= 2;
            }
        }
        return num;


    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("MCMXCVI"));
        for (int i : Arrays.asList(1996,10, 100, 1000, 1,3,4,5,6,8,9,999,1996))
        {
            System.out.println(i + " : " + romanToInteger.intToRoman(i));
        }
    }
}
