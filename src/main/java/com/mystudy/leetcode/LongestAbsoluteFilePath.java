package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianyuzhi on 16/8/24.
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() ==0) {
            return 0;
        }
        List<Integer> arr = new ArrayList<>(1000);
        String[] paths = input.split("\n");
        int index = 0;
        int curSum = 0;
        int maxSum = 0;
        for (String path : paths) {
            String[] names = path.split("\t", -1);
            int i = 0;
            int sum = 0;
            for (String name : names) {
                if (name.isEmpty()) {
                    sum += arr.get(i) + 1;
                    i ++;
                }
                else {
                    arr.add(i, name.length());
                    if (name.indexOf(".") != -1) {
                        sum += arr.get(i);
                        if (sum > maxSum) {
                            maxSum = sum;
                        }
                    }

                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        LongestAbsoluteFilePath test = new LongestAbsoluteFilePath();
        System.out.println(test.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        String str = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(test.lengthLongestPath(str));

        List<String> strs = Arrays.asList(null, "", str);
        for (String s : strs) {
            System.out.println(s + " : " + test.lengthLongestPath(s));
        }
    }
}
