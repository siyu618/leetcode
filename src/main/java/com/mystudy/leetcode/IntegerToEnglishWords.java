package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianyuzhi on 15/10/7.
 */
public class IntegerToEnglishWords {
    public static String[] weight = {"", "Thousand",  "Million", "Billion"};
    public static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] bellowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};

    public String thousandToString(int num) {
        String res = null;
        if (num >= 100) {
            res = bellowTwenty[num/100] + " Hundred";
        }
        num %= 100;
        if (num > 20) {
            res = (res == null) ? tens[num/10] : (res + " " + tens[num/10]);
            num %= 10;
            if (num > 0) {
                res += " " + bellowTwenty[num];
            }
        }
        else if (num > 0){
            res = (res == null) ? bellowTwenty[num] : (res + " " + bellowTwenty[num]);
        }
        return res;
    }


    public String numberToWords(int num) {
        if (num == 0) {return "Zero";}
        List<String> list = new ArrayList<>();
        String res = null;
        int i = (String.valueOf(num).length() - 1) / 3;
        for (; num != 0; i --) {
            int base = (int) Math.pow(10, 3 * i);
            int div = num / base;
            num = num - div * base;

            String tmp = thousandToString(div);
            if (tmp != null && !"".equals(tmp)) {
                res = (res == null) ? tmp : (res + " " + tmp);
                if (i > 0) {
                    res += " " +weight[i];
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        IntegerToEnglishWords a = new IntegerToEnglishWords();
        for (int i : Arrays.asList(1000,0, 1,3, 9, 10, 11, 17, 20, 22, 99, 100, 101, 119, 120, 122, 999, 1000, 123, 123000, 1000010, 12345, 1234567))
        {
            System.out.println(i + " : [" +  a.numberToWords(i) + "]");
        }
    }
}
