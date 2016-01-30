package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianyuzhi on 15/10/2.
 */
public class RestoreIPAddresses {
    /**
     * For example:
     Given "25525511135",

     return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>(1000);
        int[] lenArr = new int[4];
        for (int i = 0; i < lenArr.length; i ++) {
            lenArr[i]  = 0;
        }
        restore(s, lenArr, 0, 0, res);
        return res;
    }

    public void restore(String str, int[] lenArr, int index, int usedLen, List<String> res) {
        if (index == lenArr.length) {
            int iStart = 0;
            StringBuilder sb = new StringBuilder(20);
            for (int i = 0; i < lenArr.length; i ++) {
                String sub = str.substring(iStart, iStart + lenArr[i]);
                iStart = iStart + lenArr[i];
                if (sub.startsWith("0") && lenArr[i] > 1) {
                    return;
                }
                int ip = Integer.parseInt(sub);
                if (ip < 0 || ip > 255) {
                    return;
                }
                if (i != 0) {
                    sb.append('.');
                }
                sb.append(sub);
            }
            res.add(sb.toString());
            return;
        }
        if ((lenArr.length - index) * 3 < str.length() - usedLen ) {
            return;
        }
        if ((lenArr.length - index)  > str.length() - usedLen ) {
            return;
        }
        List<Integer> values = Arrays.asList(1,2,3);
        if (index == 3)  {
            values = Arrays.asList(str.length() - usedLen);
        }

        for (int i : values) {
            lenArr[index] = i;
            restore(str, lenArr, index+1, usedLen + i, res);
        }
    }

    public static void main(String[] args) {
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        for (String str : Arrays.asList("1234", "25525511135", "123", "010010")) {

            System.out.println(str + " : " + restoreIPAddresses.restoreIpAddresses(str));
        }
    }
}
